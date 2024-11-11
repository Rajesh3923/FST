public class Main {
    public static void main(String[] args) {
        // Create Model
        Employee model = new Employee("101", "Rajesh", "CSE");
        // Create View
        EmployeeView view = new EmployeeView();
        // Create Controller
        EmployeeController controller = new EmployeeController(model, view);
        // Update view initially
        controller.updateView();
        // Modify model data via controller
        controller.setEmployeeName("Ravi");
        controller.setEmployeeDept("IT");
        // Update view again with new details
        controller.updateView();
    }
}
