<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<form  method=get action='do_registration.htm'>
    <table cellspacing=1>
        <tr>
            <td width=40%>First Name *</td>
            <td><input type=text name=first_name size=100 value=''></td>
        </tr>
        <tr>
            <td>Last Name *</td>
            <td><input type=text name=last_name size=100 value=''></td>
        </tr>
        <tr>
            <td>Login *</td>
            <td><input type=text name=login size=50 value=''></td>
        </tr>
        <tr>
            <td>Password *</td>
            <td><input type=password name=password size=50 value=''></td>
        </tr>
        <tr>
            <td>Password confirm *</td>
            <td><input type=password name=password_confirm size=50 value=''></td>
        </tr>
        <tr>
            <td>Email *</td>
            <td><input type=text name=email size=100 value=''></td>
        </tr>        
        <tr>
            <td>Department Name *</td>
            <td>
 		<p>
                <select required name="department_id">
                    <option disabled>Select department</option>
                    <c:forEach items="${departments}" var="department">
                        <option value="${department.departmentId}">${department.departmentName}</option>
                    </c:forEach>
   		</select>
            </td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type=text name=phone size=100 value=''></td>
        </tr>        
        <tr>
            <td>Position</td>
            <td><input type=text name=position size=100 value=''></td>
        </tr>
      </table>
      <p><div align=center>
      <input type='submit' value='Registration' style='width: 100%'>
</form>
<p><div align=left>

<jsp:include page="footer.jsp"/>