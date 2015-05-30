package empdep.domain;

public class Department implements java.io.Serializable {
    private Integer departmentId;
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
       this.departmentName = departmentName;
    }
    
    public Department(Integer departmentId,
            String departmentName) {
       this.departmentId = departmentId; 
       this.departmentName = departmentName;
    }
   
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


