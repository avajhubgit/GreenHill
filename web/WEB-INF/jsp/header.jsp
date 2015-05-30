<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        <!--show menu-->
        <a href='employee_all_view.htm${linkMenu}'>List of employees | </a>
        <a href='department_all_view.htm${linkMenu}'>List of departments | </a>
        <a href='login.htm${linkMenu}'>Login | </a>
        <a href='registration.htm${linkMenu}'>Registration | </a>
        <a href='search.htm${linkMenu}'>Search | </a>
        <p>