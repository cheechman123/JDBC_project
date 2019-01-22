package dao;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Денис on 24.11.2018.
 */
public interface ProjectDAO {
    //create
    void add(Project address) throws SQLException;

    //read
    List<Project> getAll() throws SQLException;

    Project getByID(long id) throws SQLException;

    //update
    void update(Project address) throws SQLException;

    //delete
    void remove(Project address) throws SQLException;
}
