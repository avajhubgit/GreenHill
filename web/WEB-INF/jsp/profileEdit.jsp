<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="header.jsp"/>

<form  method=get action='do_profile_edit.htm'>
    <table cellspacing=1>
        <tr>
            <td width=40%>First Name *</td>
            <td><input type=text name=first_name size=100 value='${employee.employeeFirstName}'></td>
        </tr>
        <tr>
            <td>Last Name *</td>
            <td><input type=text name=last_name size=100 value='${employee.employeeLastName}'></td>
        </tr>
        <tr>
            <td>Login *</td>
            <td>${employee.employeeLogin}</td>
        </tr>
        <tr>
            <td>New password *</td>
            <td><input type=password name=new_password size=50 value=''></td>
        </tr>
        <tr>
            <td>New password confirm *</td>
            <td><input type=password name=new_password_confirm size=50 value=''></td>
        </tr>
        <tr>
            <td>Email *</td>
            <td><input type=text name=email size=100 value='${employee.employeeEmail}'></td>
        </tr>
        <tr>
            <td>Department ID *</td>
            <td>
 		<p>
                <select name="department_id">
                    <c:forEach items="${departments}" var="department">
                        <c:if test="${employee.departmentId != department.departmentId}">
                            <option value="${department.departmentId}">${department.departmentName}</option>
                        </c:if>
                        <c:if test="${employee.departmentId == department.departmentId}">
                            <option selected value="${department.departmentId}">${department.departmentName}</option>
                        </c:if>
                    </c:forEach>
   		</select>
	    </td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type=text name=phone size=100 value='${employee.employeePhone}'></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input type=text name=position size=100 value='${employee.employeePosition}'></td>
        </tr>
    </table>
    <input type=hidden name=id value='${employee.employeeId}'>
    <input type=hidden name=login value='${login}'>
    <input type=hidden name=password value='${password}'>
    <p><div align=center>
    <input type='submit' value='Save' style='width: 100%'>
</form>
<p><div align=left>

<jsp:include page="footer.jsp"/>