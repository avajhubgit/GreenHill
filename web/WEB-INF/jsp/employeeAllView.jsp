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
        <th>Delete employee</th>
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
            <td><a href='do_delete.htm?id=${employee.employeeId}${linkMenuSpecial}'> Delete ${employee.employeeLogin}</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer.jsp"/>