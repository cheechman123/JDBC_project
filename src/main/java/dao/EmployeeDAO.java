package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Денис on 24.11.2018.
 */
public interface EmployeeDAO {
    //create
    void add(Employee address) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    Employee getByID(long id) throws SQLException;

    //update
    void update(Employee address) throws SQLException;

    //delete
    void remove(Employee address) throws SQLException;
}
