<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<table cellspacing=1 width=100% border=1>
    <tr>
        <th width="30%">Department ID</th>
        <th>Department Name</th>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td align="right">${department.departmentId}</td>
            <td>${department.departmentName}</td>
        </tr>
    </c:forEach>
</table>
    
<jsp:include page="footer.jsp"/>