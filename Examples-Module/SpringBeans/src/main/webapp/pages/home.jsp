<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="by.nc.school.dev.example.spring.beans.service.AppStringsService" %>
<%@ page import="by.nc.school.dev.example.spring.beans.web.controller.Controller" %>
<%@ page import="by.nc.school.dev.example.spring.beans.web.command.CommandNames" %>
<%@ taglib prefix="app" uri ="/WEB-INF/custom.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><app:app-string key="<%=AppStringsService.KEY_WEB_HOME_TITLE%>"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/src/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2><app:app-string key="<%=AppStringsService.KEY_WEB_HOME_TITLE%>"/></h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col"><app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_USER%>"/></th>
                <th scope="col"><app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_PASSWORD%>"/></th>
            </tr>
        </thead>
    <c:forEach var="user" varStatus="loop" items="${users}">
        <tbody>
            <tr>
                <th scope="row">${loop.index+1}</th>
                <td>${user.login}</td>
                <td>${user.password}</td>
            </tr>
        </tbody>
    </c:forEach>
    </table>
    <form action="/controller" method="post" class="form-signin">
        <input type="hidden" name="<%=Controller.COMMAND_PARAM%>" value="<%=CommandNames.NEW_USER%>">
        <h2 class="form-signin-heading"><app:app-string key="<%=AppStringsService.KEY_WEB_HOME_NEWUSER_TITLE%>"/></h2>
        <label for="username" class="sr-only"><app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_USER%>"/></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_USER%>"/>" required autofocus>
        <label for="password" class="sr-only"><app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_PASSWORD%>"/></label>
        <input type="password" id="password" name="password" class="form-control" placeholder="<app:app-string key="<%=AppStringsService.KEY_WEB_LOGIN_PASSWORD%>"/>" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <app:app-string key="<%=AppStringsService.KEY_WEB_HOME_NEWUSER_SUBMIT%>"/>
        </button>
    </form>
</div>
</body>
</html>
