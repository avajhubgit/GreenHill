<jsp:include page="header.jsp"/>

<table cellspacing=1 width=100% border=1>
    <tr>
        <td width="30%" align=right>Employee ID</td>
        <td>${employee.employeeId}</td>
    </tr>
    <tr>
        <td align=right>First Name</td>
        <td>${employee.employeeFirstName}</td>
    </tr>
    <tr>
        <td align=right>Last Name</td>
        <td>${employee.employeeLastName}</td>
    </tr>
    <tr>
        <td align=right>Login</td>
        <td>${employee.employeeLogin}</td>
    </tr>
    <tr>
        <td align=right>Email</td>
        <td><a href='mailto: ${employee.employeeEmail}'> ${employee.employeeEmail}</a></td>
    </tr>
    <tr>
        <td align=right>Department Name</td>
        <td>${departmentName}</td>
    </tr>
    <tr>
        <td align=right>Phone</td>
        <td>${employee.employeePhone}</td>
    </tr>
    <tr>
        <td align=right>Position</td>
        <td>${employee.employeePosition}</td>
    </tr>
</table>

<jsp:include page="footer.jsp"/>