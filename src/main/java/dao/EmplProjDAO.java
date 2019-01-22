package dao;

import entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Денис on 24.11.2018.
 */
public interface EmplProjDAO {
    //create
    void add(EmplProj address) throws SQLException;

    //read
    List<EmplProj> getAll() throws SQLException;

    EmplProj getByEmployeeIDAndProjectID(long employeeID, long projectID) throws SQLException;

    //update
    void update(EmplProj address) throws SQLException;

    //delete
    void remove(EmplProj address) throws SQLException;
}
