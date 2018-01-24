<%-- 
    Document   : main
    Created on : 21.01.2018, 21:51:05
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/semantic.css"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/font-awesome-4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/semantic.js"></script>
    </head>
    <body>dfsd
        <div class="ui bottom attached segment pushable">
            <div class="ui visible labeled icon inverted left vertical sidebar menu">
                <a class="item">
                    <%--<i class="home icon"></i> --%>
                    <i class="fa fa-tachometer fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Главная
                </a>
                    <a class="item">
                    <%--<i class="home icon"></i> --%>
                    <i class="fa fa-user-o fa-3x" aria-hidden="true"></i>
                    <br/><br/>
                    Работники
                </a>
                <a class="item">
                    <i class="fa fa-list-alt fa-3x"></i>
                    <br/><br/>
                    Отчеты
                </a>
                <a class="item">
                    <i class="fa fa-calendar fa-3x"></i>
                    <br/><br/>
                    Календарь
                </a>
                <a class="item" href="${pageContext.request.contextPath}">
                    <i class="fa fa-times fa-3x"></i>
                    <br/><br/>
                    Выход
                </a>
            </div>
            <div class="ui container">
                <div class="ui basic segment">
                    <h3 class="ui header">Application Content</h3>
                    <h1 class="ui header">Hello Main JSP page!</h1>
                    <br/>
                </div>
            </div>
        </div>

    </div>

</body>
</html>
