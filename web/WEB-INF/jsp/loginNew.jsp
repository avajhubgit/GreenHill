<jsp:include page="header.jsp"/>

<form  method=get action='do_login.htm'>
    <table cellspacing=1>
        <tr>
            <td width=30%>Login *</td>
            <td><input type=text name=login size=50 value=''></td>
        </tr>
        <tr>
            <td>Password *</td>
            <td><input type=password name=password size=50 value=''></td>
        </tr>
      </table>
      <p><div align=center>
      <input type='submit' value='Login' style='width: 100%'>
</form>
<p><div align=left>

<jsp:include page="footer.jsp"/>