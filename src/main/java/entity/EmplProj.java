package entity;

/**
 * Created by Денис on 24.11.2018.
 */
public class EmplProj {
    private long employeeID;
    private long projectID;
    public EmplProj(){

    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplProj emplProj = (EmplProj) o;

        if (employeeID != emplProj.employeeID) return false;
        return projectID == emplProj.projectID;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeID ^ (employeeID >>> 32));
        result = 31 * result + (int) (projectID ^ (projectID >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                '}';
    }
}
