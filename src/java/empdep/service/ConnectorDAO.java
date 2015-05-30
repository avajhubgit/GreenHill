package empdep.service;

import empdep.domain.Department;
import empdep.domain.Employee;
import java.util.ArrayList;
import java.util.List;

//data handling layer
public class ConnectorDAO {
    private Integer nextEmployeeId = 0;
    //collection of departments
    private List<Department> departments = new ArrayList<Department>();
    //collection of employees
    private List<Employee> employees = new ArrayList<Employee>();
    //get collection of departments
    public List<Department> getAllDepartment() {
        return departments;
    }
    
    //get collection of employees
    public List<Employee> getAllEmployee() {
        return employees;
    }

    //get employee from id
    public Employee getEmployeeById(Integer employeeId) {
        //list of employee
        for (Employee e: employees) {            
            if(e.getEmployeeId().equals(employeeId)) {
                return e;
            }
        }                       
        //not found
        return null;
    }

    //get department from id
    public Department getDepartmentById(Integer departmentId) {
        //list of department
        for (Department d: departments) {            
            if(d.getDepartmentId().equals(departmentId)){
                return d;
            }
        }
        //not found
        return null;
    } 
    
    //search into list of emploees
    public List<Employee> getFilteredEmployee(String searchString) {
        //search string to upper
        String newSearchString = searchString.toUpperCase();
        //temprorary list
        List<Employee> emp_list = new ArrayList<Employee>();
        
        //for each employee from list
        for (Employee e: employees) {
            //check substring
            if  (e.getEmployeeFirstName().toUpperCase().contains(newSearchString) || 
                 e.getEmployeeLastName().toUpperCase().contains(newSearchString) ||
                 e.getEmployeeLogin().toUpperCase().contains(newSearchString) ||   
                 e.getEmployeePhone().toUpperCase().contains(newSearchString) ||
                 e.getEmployeePosition().toUpperCase().contains(newSearchString)
                 ){
                emp_list.add(e);            
            }
        }               
        return emp_list;
    }
    
    //add new employee to list
    public void addEmployee(Employee employee) {
        //define next id
        nextEmployeeId++;
        employee.setEmployeeId(nextEmployeeId);
        //add employee to list
        employees.add(employee);
    }
    
    public void updateEmployee(Employee employee) {        
    }
    
    //remove employee from list
    public void removeEmployee(Employee employee) {        
        employees.remove(employee);
    }
    
    //init departments list
    private void ReadDepartment(){        
        departments.add(new Department(1, "Information and technology department"));
        departments.add(new Department(2, "Sales department"));
        departments.add(new Department(3, "Accounting department"));
        departments.add(new Department(4, "Purchasing department"));
        departments.add(new Department(5, "Human resources department"));
        departments.add(new Department(6, "Department of orders"));
        departments.add(new Department(7, "Wholesale department"));
        departments.add(new Department(8, "Corporate department"));
        departments.add(new Department(9, "Customer care department"));
        departments.add(new Department(10, "Production department"));
    }
    
    //init employees list
    private void ReadEmployee(){        
        addEmployee(new Employee("John", "Smith", "novus", "hwejj23948293fj", "fox@gmail.com", 1, "673-91-03", "Programmer"));
        addEmployee(new Employee("Williams", "Antony", "opke", "jhwqi78r487h1o3jfhhqwf", "qwop@aol.com", 2, "740-58-23", "Accountant")); 
        addEmployee(new Employee("Brown", "Mary", "djoerk", "qioqh2t8hteurhfgowjer", "klas@tns.org", 5, "582-93-72", "Manager"));
        addEmployee(new Employee("Davis", "Peter", "pet930", "ghw87y2u3rhfqeufu8", "wbom@gmail.com", 5, "930-93-76", "Driver"));
        addEmployee(new Employee("Miller", "Cristine", "knu", "jkqt4h283uhtuiqhfwdwerg", "dfa@hotmail.com", 9, "346-87-39", "Seller"));
        addEmployee(new Employee("Taylor", "Ann", "an70", "q3th9rfiqwfherwg", "aswn_hop@gmail.com", 3, "234-49-90", "Seller"));
        addEmployee(new Employee("Anderson", "Tom", "tommy", "13io4jtu0934hgui3trg", "cro@aol.com", 2, "456-34-54", "Programmer"));
        addEmployee(new Employee("Thomas", "Lee", "lee", "h2t982hr3ofuhwerufh2374t", "hjak@uk.org", 5, "345-39-09", "Consultant"));
        addEmployee(new Employee("Jackson", "Bill", "jer", "4iouht24gfwwergwerg", "wep@hotmail.com", 5, "384-73-89", "Executive director"));
        addEmployee(new Employee("White", "Aprile", "ape", "2jihf247hfui2rhguerhgrt", "apq@yahoo.com", 3, "345-43-90", "Manager"));
    }
    
    public ConnectorDAO() {
        //init departments list
        ReadDepartment();               
        //init employees list
        ReadEmployee();
    }
}
