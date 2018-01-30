<%-- 
    Created on : 21.01.2018, 21:31:18
    Author     : Popov Aleksey
    Site       : alexnerd.com
    Email      : alexnerd85@gmail.com
    GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Time Account</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/app/main">Sign in</a>
        <br/>
        <br/>
        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
            <b>You are logged in as: </b><security:authentication property="principal.username"/>
            with the role of <security:authentication property="principal.authorities"/>
            <a href="<core:url value="/logout"/>">Logout</a>
	</security:authorize>
    </body>
</html>
