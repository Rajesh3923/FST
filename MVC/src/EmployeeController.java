public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    // Constructor
    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeId(String empId) {
        model.setEmpId(empId);
    }

    public String getEmployeeId() {
        return model.getEmpId();
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeDept(String dept) {
        model.setDept(dept);
    }

    public String getEmployeeDept() {
        return model.getDept();
    }

    public void updateView() {
        view.printEmployeeDetails(model.getEmpId(), model.getName(), model.getDept());
    }
}
