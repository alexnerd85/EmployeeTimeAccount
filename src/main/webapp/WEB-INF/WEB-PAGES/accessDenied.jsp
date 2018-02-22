<%-- 
    Document   : accessDenied
    Created on : 21.02.2018, 19:02:49
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/Semantic-UI-CSS-master/semantic.js"></script>
        <title>Доступ запрещен</title>
    </head>
    <body>
        <div class="ui middle aligned center aligned grid">
            <div class="column">
                <i class="massive frown outline icon"></i>
                <h1>Доступ запрещен!</h1>
        Привелегий Вашей учетной записи недостаточно, для доступа к запрашиваемому ресурсу.
            </div>
        </div>
    </body>
</html>
