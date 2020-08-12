<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/21
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>物料信息</title>
        <%
            pageContext.setAttribute("APP_PATH", request.getContextPath());
        %>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <meta name="apple-mobile-web-app-capable" content="yes"/>
        <link href="${APP_PATH}/static/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
        <link href="${APP_PATH}/static/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
        <link href="${APP_PATH}/static/data/styles.css" type="text/css" rel="stylesheet"/>
        <link href="${APP_PATH}/static/files/index/styles.css" type="text/css" rel="stylesheet"/>
        <script src="${APP_PATH}/static/resources/scripts/jquery-1.7.1.min.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/axQuery.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/globals.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axutils.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/annotation.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/axQuery.std.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/doc.js"></script>
        <script src="${APP_PATH}/static/data/document.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/messagecenter.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/events.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/recording.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/action.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/expr.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/geometry.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/flyout.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/ie.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/model.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/repeater.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/sto.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/utils.temp.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/variables.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/drag.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/move.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/visibility.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/style.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/adaptive.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/tree.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/init.temp.js"></script>
        <script src="${APP_PATH}/static/files/index/data.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/legacy.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/viewer.js"></script>
        <script src="${APP_PATH}/static/resources/scripts/axure/math.js"></script>
        <script type="text/javascript">
            $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
            $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
            $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
        </script>
        <script type="text/javascript"
                src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
        <link
                href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
                rel="stylesheet">
        <script
                src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    </head>
    <body>

        <!-- 员工修改的模态框 -->
        <div class="modal fade" id="itemUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">物料编辑</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">物料编码</label>
                                <div class="col-sm-6">
                                    <p class="form-control-static" id="itemCode_update_static"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">物料描述</label>
                                <div class="col-sm-6">
                                    <input type="text" name="itemDescription" class="form-control" id="itemDescription_update_input" placeholder="物料描述">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">物料单位</label>
                                <div class="col-sm-6">
                                    <select  name="itemUom" class="form-control" id="itemUom_update_input" placeholder="物料单位">
                                        <option value="米">米</option>
                                        <option value="立方米">立方米</option>
                                        <option value="平方米">平方米</option>
                                        <option value="千克">千克</option>
                                        <option value="个">个</option>
                                        <option value="其他">其他</option>
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">生效时间从</label>
                                <div class="col-sm-6">
                                    <input type="date" name="startActiveDate" class="form-control" id="startActiveDate_update_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">生效时间至</label>
                                <div class="col-sm-6">
                                    <input type="date" name="endActiveDate" class="form-control" id="endActiveDate_update_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否启用</label>
                                <div class="col-sm-6">
                                    <label class="radio-inline">
                                        <input type="radio" name="enabledFlag" id="gender1_update_input" value="true" checked="checked"> 是
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="enabledFlag" id="gender2_update_input" value="false"> 否
                                    </label>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="item_update_btn">更新</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 新建的模态框 -->
        <div class="modal fade" id="itemAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">新建物料</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">物料描述</label>
                                <div class="col-sm-6">
                                    <input type="text" name="itemDescription" class="form-control" id="itemDescription_add_input" placeholder="物料描述">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">物料单位</label>
                                <div class="col-sm-6">
                                    <select  name="itemUom" class="form-control" id="itemUom_add_input" placeholder="物料单位">
                                        <option value="米">米</option>
                                        <option value="立方米">立方米</option>
                                        <option value="平方米">平方米</option>
                                        <option value="千克">千克</option>
                                        <option value="个">个</option>
                                        <option value="其他">其他</option>
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">生效时间从</label>
                                <div class="col-sm-6">
                                    <input type="date" name="startActiveDate" class="form-control" id="startActiveDate_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">生效时间至</label>
                                <div class="col-sm-6">
                                    <input type="date" name="endActiveDate" class="form-control" id="endActiveDate_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否启用</label>
                                <div class="col-sm-6">
                                    <label class="radio-inline">
                                        <input type="radio" name="enabledFlag" id="gender1_add_input" value="true" checked="checked"> 是
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="enabledFlag" id="gender2_add_input" value="false"> 否
                                    </label>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="item_save_btn">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="base" class="">



        <!-- Title (矩形) -->
        <div id="u0" class="ax_default _一级标题" >
            <div id="u0_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u1" class="text" style="visibility: visible;">
                <p><span>物料管理</span></p>
            </div>
        </div>

        <!-- 新建按钮 (矩形) -->
        <div id="u86" class="ax_default button" >
            <div id="u86_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u87" class="text" style="visibility: visible;">
                <p><span id="add_new_item">新建</span></p>
            </div>
        </div>

        <!-- Title分割线 (水平线) -->
        <div id="u2" class="ax_default line" >
            <img id="u2_img" class="img " src="${APP_PATH}/static/images/index/title____u2.png" alt=""/>
            <!-- Unnamed () -->
            <div id="u3" class="text" style="display: none; visibility: hidden">
                <u class="col-md-pull-9"></u>
            </div>
        </div>

        <form action="select" method="post" id="select">
            <!-- 物料编码查询标签 (矩形) -->
            <div id="u4" class="ax_default text_field" >
                <div id="u4_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u5" class="text" style="visibility: visible;">
                    <p><span>物料编码</span></p>
                </div>
            </div>

            <!-- 物料编码查询条件 (文本框) -->
            <div id="u6" class="ax_default text_field" >
                <label for="u6_input"><input id="u6_input" name="itemCode" type="text" value=""/></label>
            </div>

            <!-- 物料描述查询标签 (矩形) -->
            <div id="u7" class="ax_default text_field" >
                <div id="u7_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u8" class="text" style="visibility: visible;">
                    <p><span>物料描述</span></p>
                </div>
            </div>

            <!-- 物料描述查询条件 (文本框) -->
            <div id="u9" class="ax_default text_field" >
                <label for="u9_input"><input id="u9_input" name="itemDescription" type="text" value=""/></label>
            </div>

            <!-- 物料单位查询标签 (矩形) -->
            <div id="u10" class="ax_default text_field" >
                <div id="u10_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u11" class="text" style="visibility: visible;">
                    <p><span>物料单位</span></p>
                </div>
            </div>

            <!-- 物料单位查询条件 (下拉列表框) -->
            <div id="u12" class="ax_default droplist" >
                <label for="u12_input">
                    <select id="u12_input" name="itemUom">
                        <option value=""></option>
                        <option value="米">米</option>
                        <option value="平方米">平方米</option>
                        <option value="立方米">立方米</option>
                        <option value="千克">千克</option>
                        <option value="个">个</option>
                        <option value="其他">其他</option>
                    </select>
                </label>
            </div>

            <!-- 重置按钮 (矩形) -->
            <div id="u13" class="ax_default button" >
                <div id="u13_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u14" class="text" style="visibility: visible;">
<%--                    <p><span><button value="重置" onclick="rebuild_select()"></button></span></p>--%>
                    <p><span onclick="rebuild_select()">重置</span></p>

                </div>
            </div>

            <!-- 查询按钮 (矩形) -->
            <div id="u15" class="ax_default button" style="cursor: pointer">
                <div id="u15_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u16" class="text" style="visibility: visible;">
<%--                    <input type="submit" value="查询">--%>
                    <p><span onclick="select_submit()">查询</span></p>
                </div>
            </div>

            <!-- 生效时间从查询标签 (矩形) -->
            <div id="u17" class="ax_default text_field" >
                <div id="u17_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u18" class="text" style="visibility: visible;">
                    <p><span>生效时间从</span></p>
                </div>
            </div>

            <!-- 生效时间从查询条件 (文本框) -->
            <div id="u19" class="ax_default text_field" >
                <label for="u19_input"><input id="u19_input" name="startActiveDate" type="date" value=""/></label>
            </div>

            <!-- 生效时间至查询标签 (矩形) -->
            <div  id="u20" class="ax_default text_field" >
                <div id="u20_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u21" class="text" style="visibility: visible;">
                    <p><span>生效时间至</span></p>
                </div>
            </div>

            <!-- 生效时间至查询条件 (文本框) -->
            <div id="u22" class="ax_default text_field" >
                <label for="u22_input"><input id="u22_input" name="endActiveDate" type="date" value=""/></label>
            </div>

            <!-- 是否启用查询标签 (矩形) -->
            <div id="u23" class="ax_default text_field" >
                <div id="u23_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u24" class="text" style="visibility: visible;">
                    <p><span>是否启用</span></p>
                </div>
            </div>

            <!-- 是否启用查询条件 (下拉列表框) -->
            <div id="u25" class="ax_default droplist" >
                <label for="u25_input">
                    <select id="u25_input" name="enabledFlag">
                        <option value=""></option>
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </label>

            </div>
        </form>





        <!-- 显示表格数据 -->
            <div id="u26" class="ax_default" >
                <table class="table table-hover">
                    <tr>
                        <th class="text-center">
                            <button class="btn btn-danger btn-sm "  id="item_delete_all_btn">
                                <span class=" glyphicon glyphicon-trash"></span>
                                批量删除
                            </button>
                        </th>

                        <th class="text-center">
                            <div class="text" style="visibility: visible;">
                                <a href="#" class="easyui-linkbutton" onclick="downloadfile();">数据导出</a>
                            </div>
                        </th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <th class="text-center">
                            <input type="checkbox" id="check_all"/>
                        </th>
                        <th class="text-center">物料编码</th>
                        <th class="text-center">物料描述</th>
                        <th class="text-center">物料单位</th>
                        <th class="text-center">生效时间从</th>
                        <th class="text-center">生效时间至</th>
                        <th class="text-center">是否启用</th>
                        <th class="text-center">操作</th>


                    </tr>
                    <c:forEach items="${pageInfo.list }" var="item">
                        <tr>
                            <td ><input type="checkbox" class="check_item"/></td>
                            <td class="text-center">${item.itemCode }</td>
                            <td class="text-center" >${fn:substring(item.itemDescription,0 ,10 )}</td>
                            <td class="text-center">${item.itemUom }</td>
                            <td class="text-center"><fmt:formatDate value="${item.startActiveDate }" pattern="yyyy-MM-dd" /></td>
                            <td class="text-center"><fmt:formatDate value="${item.endActiveDate }" pattern="yyyy-MM-dd" /></td>
                            <td class="text-center">${item.enabledFlag==true?'是':'否' }</td>
                            <td class="text-center">
                                <button class="btn btn-primary btn-sm edit_btn" edit-id="${item.itemId}">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                    编辑
                                </button>
                                <button class="btn btn-danger btn-sm delete_btn" del-id="${item.itemId}">
                                    <span class="glyphicon glyphicon-trash" ></span>
                                    删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                    </tr>

                    <!-- 显示分页信息 -->
                    <tr >
                        <!--分页文字信息  -->
                        <td colspan="4">
                            <div class="col-md-8 ">
                                当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total } 条记录
                            </div>
                        </td>
                        <td></td>
                        <!--每页行数-->
                        <td>
                            每页行数：
                        </td>
                        <td>
                            <select id="pageSize" name="pageSize" >
                                <option value="${pageInfo.pageSize}">${pageInfo.pageSize}</option>
                                <option  value="${APP_PATH }/select?pn=1&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=3">3</option>
                                <option  value="${APP_PATH }/select?pn=1&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=5">5</option>
                                <option  value="${APP_PATH }/select?pn=1&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=10">10</option>
                            </select>
                        </td>
                        <td  colspan="3">
                            <!-- 分页条信息 -->
                            <div class="col-md-12">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">

                                        <li><a href="${APP_PATH }/select?pn=1&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}"  >首页</a></li>
                                        <c:if test="${pageInfo.hasPreviousPage }">
                                            <li><a href="${APP_PATH }/select?pn=${pageInfo.pageNum-1}&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}"
                                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                            </a></li>
                                        </c:if>


                                        <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                                            <c:if test="${page_Num == pageInfo.pageNum }">
                                                <li class="active"><a href="#">${page_Num }</a></li>
                                            </c:if>
                                            <c:if test="${page_Num != pageInfo.pageNum }">
                                                <li><a href="${APP_PATH }/select?pn=${page_Num }&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}">${page_Num }</a></li>
                                            </c:if>

                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage }">
                                            <li><a href="${APP_PATH }/select?pn=${pageInfo.pageNum+1 }&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}"
                                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                            </a></li>
                                        </c:if>
                                        <li><a href="${APP_PATH }/select?pn=${pageInfo.pages}&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}">末页</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </td>
                    </tr>

                </table>

            </div>




        </div>
        <script type="text/javascript">
            <%--   #u6_input #u9_input #u12_input #u19_input #u22_input #u25_input         --%>
            //重置按钮，置空所有查询条件
            function rebuild_select() {
                document.getElementById("u6_input").value = "";
                document.getElementById("u9_input").value = "";
                document.getElementById("u12_input").value = "";
                document.getElementById("u19_input").value = "";
                document.getElementById("u22_input").value = "";
                document.getElementById("u25_input").value = "";
                window.location.href = "/items";
            }

            //提交查询检验不为空
            function select_submit() {
                if( $("#u6_input").val() == '' && $("#u9_input").val() == ''
                    && $("#u12_input").val() == '' &&$("#u19_input").val() == ''
                    && $("#u22_input").val() == '' &&$("#u25_input").val() == '' )
                {
                    alert("查询条件不得为空！")
                }
                else{
                    $("#select").submit();

                }
            }

            //清空表单样式及内容
            function reset_form(ele){
                $(ele)[0].reset();
                //清空表单样式
                $(ele).find("*").removeClass("has-error has-success");
                $(ele).find(".help-block").text("");
            }

            //点击新增按钮弹出模态框。
            $("#add_new_item").click(function(){
                //清除表单数据（表单完整重置（表单的数据，表单的样式））
                reset_form("#itemAddModal form");
                //s$("")[0].reset();
                //弹出模态框
                $("#itemAddModal").modal({
                    backdrop:"static"
                });
            });

            //新增校验表单数据
            function validate_add_form(){
                //1、校验物料描述是否为空
                var itemDescription = $("#itemDescription_add_input").val();
                if(''== itemDescription){
                    //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
                    show_validate_msg("#itemDescription_add_input", "error", "物料描述不得为空");
                    return false;
                }else{
                    show_validate_msg("#itemDescription_add_input", "success", "");
                };


                return true;
            }

            //显示校验结果的提示信息
            function show_validate_msg(ele,status,msg){
                //清除当前元素的校验状态
                $(ele).parent().removeClass("has-success has-error");
                $(ele).next("span").text("");
                if("success"==status){
                    $(ele).parent().addClass("has-success");
                    $(ele).next("span").text(msg);
                }else if("error" == status){
                    $(ele).parent().addClass("has-error");
                    $(ele).next("span").text(msg);
                }
            }

            //点击保存，保存员工。
            $("#item_save_btn").click(function(){
                //1、模态框中填写的表单数据提交给服务器进行保存
                //1、先对要提交给服务器的数据进行校验
                if(!validate_add_form()){
                    return false;
                };


                //2、发送ajax请求保存员工
                $.ajax({
                    url:"${APP_PATH}/item",
                    type:"POST",
                    data:$("#itemAddModal form").serialize(),
                    success:function(result){
                        //alert(result.msg);
                        if(result.code == 100){
                            //员工保存成功；
                            //关闭模态框
                            $("#itemAddModal").modal('hide');

                        }else{
                            //显示失败信息
                            //console.log(result);
                            //有哪个字段的错误信息就显示哪个字段的；

                            if(undefined != result.extend.errorFields.itemDescription){
                                //显示物料描述的错误信息
                                show_validate_msg("#itemDescription_add_input", "error", result.extend.errorFields.itemDescription);
                            }
                        }
                    }
                });
                window.location.href = "/items";
            });

            //1、我们是按钮创建之前就绑定了click，所以绑定不上。
            //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
            //jquery新版没有live，使用on进行替代
            $(document).on("click",".edit_btn",function(){
                //alert("edit");


                //2、查出员工信息，显示员工信息
                getItem($(this).attr("edit-id"));

                //3、把员工的id传递给模态框的更新按钮
                $("#item_update_btn").attr("edit-id",$(this).attr("edit-id"));
                $("#itemUpdateModal").modal({
                    backdrop:"static"
                });
            });

            function getItem(id){
                $.ajax({
                    url:"${APP_PATH}/item/"+id,
                    type:"GET",
                    success:function(result){
                        //console.log(result);
                        var itemData = result.extend.item;
                        $("#itemCode_update_static").text(itemData.itemCode);
                        $("#itemDescription_update_input").val(itemData.itemDescription);
                        $("#itemUpdateModal select").val([itemData.itemUom]);
                        $("#itemUpdateModal input[name=startActiveDate]").val([itemData.startActiveDate]);
                        $("#itemUpdateModal input[name=endActiveDate]").val([itemData.endActiveDate]);
                        $("#itemUpdateModal input[name=enabledFlag]").val([itemData.enabledFlag]);
                    }
                });
            }



            //点击更新，更新员工信息
            $("#item_update_btn").click(function(){

                //1、校验物料描述是否为空
                var itemDescription = $("#itemDescription_update_input").val();
                if(''== itemDescription){
                    //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
                    show_validate_msg("#itemDescription_update_input", "error", "物料描述不得为空");
                    return false;
                }else{
                    show_validate_msg("#itemDescription_update_input", "success", "");
                };

                //2、发送ajax请求保存更新的员工数据
                $.ajax({
                    url:"${APP_PATH}/item/"+$(this).attr("edit-id"),
                    type:"PUT",
                    data:$("#itemUpdateModal form").serialize(),
                    success:function(result){
                        //alert(result.msg);
                        //1、关闭对话框
                        $("#itemUpdateModal").modal("hide");
                        //2. 回到当前页面
                        to_page();
                    }
                });
                // window.location.href = "/items";
            });

            //单个删除
            $(document).on("click",".delete_btn",function(){
                //1、弹出是否确认删除对话框
                var itemCode = $(this).parents("tr").find("td:eq(1)").text();
                var itemId = $(this).attr("del-id");
                //alert($(this).parents("tr").find("td:eq(1)").text());
                if(confirm("确认删除【"+itemCode+"】吗？")){
                    //确认，发送ajax请求删除即可
                    $.ajax({
                        url:"${APP_PATH}/item/"+itemId,
                        type:"DELETE",
                        success:function(result){
                            alert(result.msg);
                            //回到本页
                            to_page();
                        }
                    });
                }
                // window.location.href="/items";
            });

            function to_page(){
                window.location.href = "${APP_PATH }/select?pn=${pageInfo.pageNum }&itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}&pageSize=${pageInfo.pageSize}";
            }

            //完成全选/全不选功能
            $("#check_all").click(function(){
                //attr获取checked是undefined;
                //我们这些dom原生的属性；attr获取自定义属性的值；
                //prop修改和读取dom原生属性的值
                $(".check_item").prop("checked",$(this).prop("checked"));
            });

            //check_item
            $(document).on("click",".check_item",function(){
                //判断当前选择中的元素是否5个
                var flag = $(".check_item:checked").length==$(".check_item").length;
                $("#check_all").prop("checked",flag);
            });

            //点击全部删除，就批量删除
            $("#item_delete_all_btn").click(function(){
                //
                var itemCodes = "";
                var del_idstr = "";
                $.each($(".check_item:checked"),function(){
                    //this
                    itemCodes += $(this).parents("tr").find("td:eq(2)").text()+",";
                    //组装员工id字符串
                    del_idstr += $(this).parents("tr").find(".delete_btn").attr("del-id")+"-";
                });
                if('' == del_idstr)
                {
                    alert("请选择要删除的物料")
                }
                else{
                    //去除empNames多余的,
                    itemCodes = itemCodes.substring(0, itemCodes.length-1);
                    //去除删除的id多余的-
                    del_idstr = del_idstr.substring(0, del_idstr.length-1);
                    if(confirm("确认删除【"+del_idstr+"】吗？")){
                        //发送ajax请求删除
                        $.ajax({
                            url:"${APP_PATH}/item/"+del_idstr,
                            type:"DELETE",
                            success:function(result){
                                alert(result.msg);
                                //回到当前页面
                                to_page();
                            }
                        });
                    }
                    // window.location.href="/items";
                }

            });


            //数据导出链接
            function downloadfile(){
                window.location.href="/itemExcelDownloads?itemCode=${selection.itemCode}&itemDescription=${selection.itemDescription}&itemUom=${selection.itemUom}&startActiveDate=<fmt:formatDate value="${selection.startActiveDate }" pattern="yyyy-MM-dd" />&endActiveDate=<fmt:formatDate value="${selection.endActiveDate }" pattern="yyyy-MM-dd" />&enabledFlag=${selection.enabledFlag}";
            }

            //改变分页显示数量
            $('#pageSize').change(function () {
                // alert($(this).children('option:selected').val())
                window.location.href = $(this).children('option:selected').val()
            })





        </script>
    </body>
</html>
