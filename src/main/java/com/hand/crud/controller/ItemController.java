package com.hand.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.crud.bean.Item;
import com.hand.crud.bean.Msg;
import com.hand.crud.service.ItemService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sun.plugin.viewer.context.IExplorerAppletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author huaxin
 * @Date 2020/7/21
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //首页展示所有物料
    @RequestMapping("/items")
    public String getItems(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                           Model model,HttpSession session,
                           @RequestParam(value="pageSize",defaultValue = "5")Integer pageSize) throws ServletException, IOException {


        PageHelper.startPage(pn,3);
        List<Item> items = itemService.getAll();
        PageInfo pageInfo = new PageInfo(items,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo.toString());
        System.out.println("************************");
        System.out.println(pageInfo.getList().get(0).toString());

        return "index";
    }


    //根据筛选条件查询物料
    @RequestMapping("/select")
    public String getBySelection(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                 Model model,
                                 HttpServletRequest req,
                                 HttpSession session,
                                 @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize) throws ParseException {

        Item item = new Item();

        //模糊查询物料编码
        if(req.getParameter("itemCode")!=null && !"".equals(req.getParameter("itemCode"))){
            item.setItemCode("%"+req.getParameter("itemCode")+"%");

        }
        //模糊查询描述
        if(req.getParameter("itemDescription")!=null && !"".equals(req.getParameter("itemDescription"))){
            item.setItemDescription("%"+req.getParameter("itemDescription")+"%");
        }
        if(req.getParameter("itemUom")!=null && !"".equals(req.getParameter("itemUom"))){
            item.setItemUom(req.getParameter("itemUom"));
        }
        System.out.println("startActiveDate:"+req.getParameter("startActiveDate"));
        if(req.getParameter("startActiveDate")!=null && !"".equals(req.getParameter("startActiveDate"))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            item.setStartActiveDate(sdf.parse(req.getParameter("startActiveDate")));
        }
        if(req.getParameter("endActiveDate")!=null && !"".equals(req.getParameter("endActiveDate"))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            item.setEndActiveDate(sdf.parse(req.getParameter("endActiveDate")));
        }
        if(req.getParameter("enabledFlag")!=null && !"".equals(req.getParameter("enabledFlag"))){
            item.setEnabledFlag(Boolean.valueOf(req.getParameter("enabledFlag")));
        }


        System.out.println(item.toString());
        //分页查询
        PageHelper.startPage(pn,pageSize);
        List<Item> items = itemService.getBySelection(item);

        //存入model前，去除模糊查询，用于分页跳转
        if(req.getParameter("itemCode")!=null && !"".equals(req.getParameter("itemCode"))){
            item.setItemCode(req.getParameter("itemCode"));
        }
        if(req.getParameter("itemDescription")!=null && !"".equals(req.getParameter("itemDescription"))){
            item.setItemDescription(req.getParameter("itemDescription"));
        }

        model.addAttribute("selection",item);

        PageInfo pageInfo = new PageInfo(items,5);
        model.addAttribute("pageInfo",pageInfo);


        System.out.println(pageInfo.toString());
        System.out.println("************************");
        if(items.size()!=0){
            System.out.println("list.size:"+pageInfo.getList().size()+pageInfo.getList().get(0).toString());
        }
        return "index";
    }


    /**
     * 物料Msg保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     *
     * @return
     */
    @RequestMapping(value="/item",method=RequestMethod.POST)
    @ResponseBody
    public Msg saveItem(@Valid Item item, BindingResult result){
        if(result.hasErrors()){
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            itemService.saveItem(item);
            return Msg.success();
        }
    }

    /**
     * 根据id查询物料，传递数据，弹出模态框
     * @param id
     * @return
     */
    @RequestMapping(value="/item/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Long id){

        Item item = itemService.getById(id);
        return Msg.success().add("item", item);
    }

    /**
     * 解决方案；
     * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
     * 1、配置上HttpPutFormContentFilter；
     * 2、他的作用；将请求体中的数据解析包装成一个map。
     * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
     * 员工更新方法
     * @param item
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/item/{itemId}",method=RequestMethod.PUT)
    public Msg updateItem(Item item,HttpServletRequest request){
//        item.setObjectVersionNumber(item.getObjectVersionNumber()+1L);
        System.out.println("将要更新的员工数据："+item);

        itemService.updateItem(item);
        return Msg.success()	;
    }

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/item/{ids}",method=RequestMethod.DELETE)
    public Msg deleteItem(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Long> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Long.valueOf(string));
            }
            itemService.deleteBatch(del_ids);
        }else{
            Long id = Long.valueOf((ids));
            itemService.deleteItem(id);
        }
        return Msg.success();
    }

    //导出Excle
    @RequestMapping("/itemExcelDownloads")
    public void itemsExcelDownloads(HttpServletResponse response,
                                    HttpServletRequest req) throws IOException, ParseException {
        Item item = new Item();

        //只导出符合当前筛选条件的数据
        //模糊查询物料编码
        if(req.getParameter("itemCode")!=null && !"".equals(req.getParameter("itemCode"))){
            item.setItemCode("%"+req.getParameter("itemCode")+"%");

        }
        //模糊查询描述
        if(req.getParameter("itemDescription")!=null && !"".equals(req.getParameter("itemDescription"))){
            item.setItemDescription("%"+req.getParameter("itemDescription")+"%");
        }
        if(req.getParameter("itemUom")!=null && !"".equals(req.getParameter("itemUom"))){
            item.setItemUom(req.getParameter("itemUom"));
        }
        if(req.getParameter("startActiveDate")!=null && !"".equals(req.getParameter("startActiveDate"))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            item.setStartActiveDate(sdf.parse(req.getParameter("startActiveDate")));
        }
        if(req.getParameter("endActiveDate")!=null && !"".equals(req.getParameter("endActiveDate"))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            item.setEndActiveDate(sdf.parse(req.getParameter("endActiveDate")));
        }
        if(req.getParameter("enabledFlag")!=null && !"".equals(req.getParameter("enabledFlag"))){
            item.setEnabledFlag(Boolean.valueOf(req.getParameter("enabledFlag")));
        }


        System.out.println(item.toString());
        //分页查询
        List<Item> items = itemService.getBySelection(item);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("物料信息表");


        //设置要导出的文件的名字
        String fileName = "items"+UUID.randomUUID().toString().substring(0,10) + ".xls";
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "物料编码", "物料描述", "物料单位", "生效日期从", "生效日期至", "是否启用"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //在表中存放查询到的数据放入对应的列
        for (Item itemTemp : items) {
            HSSFRow row1 = sheet.createRow(rowNum);

            row1.createCell(0).setCellValue(itemTemp.getItemCode());
            row1.createCell(1).setCellValue(itemTemp.getItemDescription());
            row1.createCell(2).setCellValue(itemTemp.getItemUom());
            //防止空指针异常
            if (itemTemp.getStartActiveDate() != null) {
                row1.createCell(3).setCellValue(sdf.format(itemTemp.getStartActiveDate()));
            }
            if(itemTemp.getEndActiveDate() != null){
                row1.createCell(4).setCellValue(sdf.format(itemTemp.getEndActiveDate()));
            }
            row1.createCell(5).setCellValue(itemTemp.getEnabledFlag());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }


}
