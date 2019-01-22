package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 25.11.2018.
 */
public class EmplProjService extends Util implements EmplProjDAO {

    Connection connection = getConnection();


    @Override
    public void add(EmplProj emplproj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "insert into EMPL_PROJ ( employee_id, project_id) values (?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplproj.getEmployeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplprojList = new ArrayList<>();
        String sql = "select employee_id, project_id from EMPL_PROJ";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplproj = new EmplProj();
                emplproj.setEmployeeID(resultSet.getLong("employee_id"));
                emplproj.setProjectID(resultSet.getLong("project_id"));


                emplprojList.add(emplproj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return emplprojList;
    }

    @Override
    public EmplProj getByEmployeeIDAndProjectID(long employeeID, long projectID) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "select employee_id, project_id from EMPL_PROJ where employee_id=? and project_id=?";
        EmplProj emplproj = new EmplProj();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employeeID);
            preparedStatement.setLong(2, projectID);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplproj.setEmployeeID(resultSet.getLong("employee_id"));
            emplproj.setProjectID(resultSet.getLong("project_id"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return emplproj;
    }


    @Override
    public void update(EmplProj emplproj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "update EMPL_PROJ set employee_id=?, project_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, emplproj.getEmployeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public void remove(EmplProj emplproj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "delete from emplproj where employee_id=? and project_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplproj.getEmployeeID());
            preparedStatement.setLong(2, emplproj.getProjectID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}