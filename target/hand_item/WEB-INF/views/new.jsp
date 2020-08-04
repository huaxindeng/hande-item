<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/22
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <form action="new" method="post" id="new">

            <div id="u92" class="ax_default label" >
                <div id="u92_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u93" class="text" style="visibility: visible;">
                    <p><span>物料描述</span></p>
                </div>
            </div>


            <!-- 物料描述输入框 (文本框) -->
            <div id="u94" class="ax_default text_field" >
                <label for="u94_input"><input id="u94_input" name="itemDescription" type="text" value=""/></label>
            </div>


            <!-- 物料单位查询标签 (矩形) -->
            <div id="u95" class="ax_default text_field" >
                <div id="u95_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u96" class="text" style="visibility: visible;">
                    <p><span>物料单位</span></p>
                </div>
            </div>

            <!-- 物料单位查询条件 (下拉列表框) -->
            <div id="u97" class="ax_default droplist" >
                <label for="u97_input">
                    <select id="u97_input" name="itemUom">
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

            <!-- 生效时间从查询标签 (矩形) -->
            <div id="u98" class="ax_default text_field" >
                <div id="u98_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u99" class="text" style="visibility: visible;">
                    <p><span>生效时间从</span></p>
                </div>
            </div>

            <!-- 生效时间从查询条件 (文本框) -->
            <div id="u100" class="ax_default text_field" >
                <label for="u100_input"><input id="u100_input" name="startActiveDate" type="date" value=""/></label>
            </div>

            <!-- 生效时间至查询标签 (矩形) -->
            <div  id="u101" class="ax_default text_field" >
                <div id="u101_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u102" class="text" style="visibility: visible;">
                    <p><span>生效时间至</span></p>
                </div>
            </div>

            <!-- 生效时间至查询条件 (文本框) -->
            <div id="u103" class="ax_default text_field" >
                <label for="u103_input"><input id="u103_input" name="endActiveDate" type="date" value=""/></label>
            </div>

            <!-- 是否启用查询标签 (矩形) -->
            <div id="u105" class="ax_default text_field" >
                <div id="u105_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u106" class="text" style="visibility: visible;">
                    <p><span>是否启用</span></p>
                </div>
            </div>

            <!-- 是否启用查询条件 (下拉列表框) -->
            <div id="u104" class="ax_default droplist" >
                <label for="u104_input">
                    <select id="u104_input" name="enabledFlag">
                        <option value=""></option>
                        <option value="是">是</option>
                        <option value="否">否</option>
                    </select>
                </label>
            </div>

            <!-- 保存按钮 (矩形) -->
            <div id="u107" class="ax_default primary_button" >
                <div id="u107_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u108" class="text" style="visibility: visible;">
                    <p><span onclick="new_submit()">保存</span></p>
                </div>
            </div>

            <!-- 返回按钮 (矩形) -->
            <div id="u109" class="ax_default button" >
                <div id="u109_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u110" class="text" style="visibility: visible;">
                    <p><span onclick="new_return()">返回</span></p>
                </div>
            </div>
        </form>
        
    </body>
</html>
