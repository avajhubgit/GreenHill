package empdep.domain;

public class Employee implements java.io.Serializable {
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeLogin;
    private String employeePassword;
    private String employeeEmail;
    private Integer departmentId;//the department in which the employee works
    private String employeePhone;
    private String employeePosition;//position name

    public Employee() {
    }
	
    public Employee(String employeeFirstName, String employeeLastName, String employeeLogin, String employeePassword, String employeeEmail, Integer departmentId) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeLogin = employeeLogin;
        this.employeePassword = employeePassword;
        this.employeeEmail = employeeEmail;
        this.departmentId = departmentId;
    }

    public Employee(String employeeFirstName, String employeeLastName, String employeeLogin, String employeePassword, String employeeEmail, Integer departmentId, String employeePhone, String employeePosition) {
       this.employeeFirstName = employeeFirstName;
       this.employeeLastName = employeeLastName;
       this.employeeLogin = employeeLogin;
       this.employeePassword = employeePassword;
       this.employeeEmail = employeeEmail;
       this.departmentId = departmentId;
       this.employeePhone = employeePhone;
       this.employeePosition = employeePosition;
    }
   
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }
    
    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    public String getEmployeeLastName() {
        return this.employeeLastName;
    }
    
    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }
    public String getEmployeeLogin() {
        return this.employeeLogin;
    }
    
    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }
    public String getEmployeePassword() {
        return this.employeePassword;
    }
    
    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
    public String getEmployeeEmail() {
        return this.employeeEmail;
    }
    
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getEmployeePhone() {
        return this.employeePhone;
    }
    
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
    public String getEmployeePosition() {
        return this.employeePosition;
    }
    
    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
}


