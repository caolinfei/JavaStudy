<%@ page import="java.util.List" %>
<%@ page import="com.crud.domian.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    引入lib使用JTEL
--%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }

        .row-grid {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <form method="${pageContext.request.contextPath}/indexServlet">
            <%--<div class="panel-body">
                <div class="row row-grid">
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon title">名称</span>
                            <input type="text" class="form-control" name="name" value=""/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon title">年龄</span>
                            <input type="text" class="form-control" name="age" value=""/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="input-group">
                            <span class="input-group-addon title">编号</span>
                            <input type="text" class="form-control" name="id" value=""/>
                        </div>
                    </div>
                </div>

                <div class="row row-grid">
                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="" onclick="">搜索</button>
                    </div>
                </div>
            </div>--%>


        </form>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">Panel heading without title</div>
        <div class="panel-body">
            <div class="row row-grid">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon" >@</span>
                        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
            </div>
            <div class="row row-grid">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon" >@</span>
                        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
            </div>
            <div class="row row-grid">
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="" onclick="">搜索</button>
                </div>
            </div>
        </div>
    </div>


    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" class="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${requestScope.person}" var="p" varStatus="count">
            <tr>
                <td>${count.count}</td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <c:if test="${p.sex==true}">
                    <td>男</td>
                </c:if>
                <c:if test="${p.sex==false}">
                    <td>女</td>
                </c:if>
                <td>${p.age}</td>
                <td>${p.address}</td>
                <td>${p.qq}</td>
                <td>${p.email}</td>
                <td>操作</td>
            </tr>
        </c:forEach>


    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>
</body>
</html>
