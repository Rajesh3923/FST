public class Employee {
    private String empId;
    private String name;
    private String dept;

    // Constructor
    public Employee(String empId, String name, String dept) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
    }

    // Getters and Setters
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
