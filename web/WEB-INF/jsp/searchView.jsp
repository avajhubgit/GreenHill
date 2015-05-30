<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<table cellspacing=1 width=100% border=1>
    <tr>
        <th>Employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>Department Name</th>
        <th>Phone</th>
        <th>Position</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td align="right">${employee.employeeId}</td>
            <td>
                <c:if test="${empty login}">                    
                    <a href='profile_view.htm?id=${employee.employeeId}'> ${employee.employeeFirstName}</a>
                </c:if>
                <c:if test="${not empty login}">
                    <c:if test="${login eq employee.employeeLogin}">
                        <a href='profile_edit.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeFirstName}</a>
                    </c:if>
                    <c:if test="${login ne employee.employeeLogin}">
                        <a href='profile_view.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeFirstName}</a>
                    </c:if>
                </c:if>
            </td>
            <td>
                <c:if test="${empty login}">
                    <a href='profile_view.htm?id=${employee.employeeId}'> ${employee.employeeLastName}</a>
                </c:if>
                <c:if test="${not empty login}">
                    <c:if test="${login eq employee.employeeLogin}">
                        <a href='profile_edit.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeLastName}</a>
                    </c:if>
                    <c:if test="${login ne employee.employeeLogin}">
                        <a href='profile_view.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeLastName}</a>
                    </c:if>
                </c:if>
            </td>
            <td>
                <c:if test="${empty login}">
                    <a href='profile_view.htm?id=${employee.employeeId}'> ${employee.employeeLogin}</a>
                </c:if>
                <c:if test="${not empty login}">
                    <c:if test="${login eq employee.employeeLogin}">
                        <a href='profile_edit.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeLogin}</a>
                    </c:if>
                    <c:if test="${login ne employee.employeeLogin}">
                        <a href='profile_view.htm?id=${employee.employeeId}${linkMenuSpecial}'> ${employee.employeeLogin}</a>
                    </c:if>
                </c:if>
            </td>
            <td><a href='mailto: ${employee.employeeEmail}'> ${employee.employeeEmail}</a></td>
            <td>
                <c:forEach items="${departments}" var="department">
                    <c:if test="${employee.departmentId == department.departmentId}">${department.departmentName}</c:if>
                </c:forEach>
            </td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeePosition}</td>
        </tr>
    </c:forEach>
</table>
<p>
<form  method=get action='do_search.htm'>
    <table cellspacing=1>
        <tr>
            <td width=40%>Input text *</td>
            <td><input type=text name=search_string size=100 value='${search}'></td>
        </tr>
      </table>
      <input type=hidden name=login value='${login}'>
      <input type=hidden name=password value='${password}'>
      <p><div align=center>      
      <input type='submit' value='Search' style='width: 100%'>  
</form> 
<p><div align=left> 

<jsp:include page="footer.jsp"/>    