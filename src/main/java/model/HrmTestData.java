package model;

public class HrmTestData {

    private String username;
    private String password;
    private String expectedFullName;
    private String employeeNumber;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedFullName() {
        return expectedFullName;
    }

    public void setExpectedFullName(String expectedFullName) {
        this.expectedFullName = expectedFullName;
    }
}
