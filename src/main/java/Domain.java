import bl.Util;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Денис on 24.11.2018.
 */
public class Domain {
    public static void main(String[] args){

        Util util = new Util();
        util.getConnection();

        AddressService addressService = new AddressService();
        EmplProjService emplProjService = new EmplProjService();
        ProjectService projectService = new ProjectService();
        EmployeeService employeeService = new EmployeeService();

        Address address = new Address();
        address.setId(2L);
        address.setCountry("Ukraine");
        address.setCity("Kharkiv");
        address.setStreet("MyStreet street 1");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setFirstName("Denis");
        employee.setLastName("Lavrenov");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.MAY, 3);
        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddressID(address.getId());

        Project project = new Project();
        project.setId(2L);
        project.setTitle("Student");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeID(employee.getId());
        emplProj.setProjectID(project.getId());

        try{
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            emplProjService.add(emplProj);

        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
