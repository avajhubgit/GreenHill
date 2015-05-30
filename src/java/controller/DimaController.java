package controller;
 
import empdep.domain.Department;
import empdep.domain.Employee;
import empdep.service.ConnectorDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DimaController {
    private ConnectorDAO connectorDAO = new ConnectorDAO();
    
    @RequestMapping(value = {"/index.htm", "/employee_all_view.htm"}, method = RequestMethod.GET)
    public String showDefault(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
            
        model.addAttribute("title", "List of employees");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "employeeAllView";
    }
 
    @RequestMapping(value = "/department_all_view.htm", method = RequestMethod.GET)
    public String showDepartments(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
            
        model.addAttribute("title", "List of departments");
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        return "departmentAllView";
    }
    
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String showLogin(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
            
        model.addAttribute("title", "Login");
        return "loginNew";
    }
    
    @RequestMapping(value = "/do_login.htm", method = RequestMethod.GET)
    public String doLogin(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
        
        //check user login and password
        
        model.addAttribute("title", "List of employees");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "employeeAllView";
    }
    
    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public String showRegistration(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
        model.addAttribute("title", "Registration");

        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());

        return "registrationNew";
    }
    
    @RequestMapping(value = "/do_registration.htm", method = RequestMethod.GET)
    public String doRegistration(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
	    @RequestParam(value = "first_name", required = false, defaultValue = "") String employeeFirstNameString,
            @RequestParam(value = "last_name", required = false, defaultValue = "") String employeeLastNameString,
            @RequestParam(value = "email", required = false, defaultValue = "") String employeeEmailString,
            @RequestParam(value = "department_id", required = false, defaultValue = "1") Integer departmentIdInteger,
            @RequestParam(value = "phone", required = false, defaultValue = "") String employeePhoneString,
            @RequestParam(value = "position", required = false, defaultValue = "") String employeePositionString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
    
        //create new employee
        Employee employee = new Employee(employeeFirstNameString, 
            employeeLastNameString, loginString, passwordString, employeeEmailString, 
            departmentIdInteger, employeePhoneString, employeePositionString);
        //add employee to list
        connectorDAO.addEmployee(employee);

        model.addAttribute("title", "List of employees");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "employeeAllView";
    }
    
    @RequestMapping(value = "/search.htm", method = RequestMethod.GET)
    public String showSearch(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
            
        model.addAttribute("title", "Search");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "searchView";
    }
    
    @RequestMapping(value = "/do_search.htm", method = RequestMethod.GET)
    public String doSearch(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            @RequestParam(value = "search_string", required = false, defaultValue = "") String searchString,
            Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
        
        //filtered emploee list
        
        model.addAttribute("title", "Search");
        model.addAttribute("search", searchString);
        //handle employee list
        if(searchString.isEmpty()){
            //show all emploees
            model.addAttribute("employees", connectorDAO.getAllEmployee());
        }
        else{
            //show filtered employees
            model.addAttribute("employees", connectorDAO.getFilteredEmployee(searchString));
        }
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "searchView";
    }
    
    @RequestMapping(value = "/profile_edit.htm", method = RequestMethod.GET)
    public String editProfile(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            @RequestParam("id") Integer id, Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
    
        if (null == id){
            return "Error: employee id is null";
        }

        //handle employee
        Employee employee;
        employee = connectorDAO.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("title", "Edit profile " + employee.getEmployeeFirstName() + " " + employee.getEmployeeLastName());
        
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "profileEdit";
    }
    
    @RequestMapping(value = "/do_profile_edit.htm", method = RequestMethod.GET)
    public String doProfileEdit(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
	    @RequestParam(value = "first_name", required = false, defaultValue = "") String employeeFirstNameString,
            @RequestParam(value = "last_name", required = false, defaultValue = "") String employeeLastNameString,
            @RequestParam(value = "email", required = false, defaultValue = "") String employeeEmailString,
            @RequestParam(value = "department_id", required = false, defaultValue = "1") Integer departmentIdInteger,
            @RequestParam(value = "phone", required = false, defaultValue = "") String employeePhoneString,
            @RequestParam(value = "position", required = false, defaultValue = "") String employeePositionString,
            @RequestParam("id") Integer id, Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
        
        //save employee
        if (null == id){
            return "Error: employee id is null";
        }

        //handle employee
        Employee employee;
        employee = connectorDAO.getEmployeeById(id);
        employee.setEmployeeFirstName(employeeFirstNameString);
        employee.setEmployeeLastName(employeeLastNameString);
        employee.setEmployeeEmail(employeeEmailString);
        employee.setDepartmentId(departmentIdInteger);
        employee.setEmployeePhone(employeePhoneString);
        employee.setEmployeePosition(employeePositionString);
        
        model.addAttribute("title", "List of employees");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "employeeAllView";
    }    
    
    //login and password
    private void readLoginAndPassword(Model model, String loginString, String passwordString){
        //login and password
        model.addAttribute("login", loginString);
        model.addAttribute("password", passwordString);
        //link for all parameters
        String linkMenu = "";
        if(!(loginString.isEmpty()) && (passwordString.isEmpty()))
        {    
            linkMenu = "?login=" + loginString;
        }
        if((loginString.isEmpty()) && !(passwordString.isEmpty()))
        {    
            linkMenu = "?password=" + passwordString;
        }
        if(!(loginString.isEmpty()) && !(passwordString.isEmpty()))
        {    
            linkMenu = "?password=" + passwordString + "&login=" + loginString;
        }
        if(linkMenu.isEmpty()){
            model.addAttribute("linkMenu", "");
            model.addAttribute("linkMenuSpecial", "");
        }
        else{
            model.addAttribute("linkMenu", linkMenu);
            model.addAttribute("linkMenuSpecial", "&" + linkMenu.substring(1));
        }
            
    }
    
    @RequestMapping(value = "/profile_view.htm", method = RequestMethod.GET)
    public String showProfile(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            @RequestParam("id") Integer id, Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
        
        if (null == id){
            return "Error: employee id is null";
        }
                
        //handle employee
        Employee employee;
        employee = connectorDAO.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("title", "Profile " + employee.getEmployeeFirstName() + " " + employee.getEmployeeLastName());
        
        //handle department
        Department department;
        department = connectorDAO.getDepartmentById(employee.getDepartmentId());
        model.addAttribute("departmentName", department.getDepartmentName());
        return "profileView";
    }

    @RequestMapping(value = "/do_delete.htm", method = RequestMethod.GET)
    public String doDelete(@RequestParam(value = "login", required = false, defaultValue = "") String loginString,
            @RequestParam(value = "password", required = false, defaultValue = "") String passwordString,
            @RequestParam("id") Integer id, Model model) {
        //login and password
        readLoginAndPassword(model, loginString, passwordString);
    
        if (null == id){
            return "Error: employee id is null";
        }

        //handle employee
        Employee employee;
        employee = connectorDAO.getEmployeeById(id);

        //remove employee from list
        connectorDAO.removeEmployee(employee);

        model.addAttribute("title", "List of employees");
        //handle employee list
        model.addAttribute("employees", connectorDAO.getAllEmployee());
        //handle department list
        model.addAttribute("departments", connectorDAO.getAllDepartment());
        
        return "employeeAllView";
    }


}