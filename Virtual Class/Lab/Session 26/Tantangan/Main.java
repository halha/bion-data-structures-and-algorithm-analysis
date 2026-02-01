public class Main {

  public static void main(String[] args) {
    DataEmployee employees = new DataEmployee(5);

    employees.put(101, "Hammam");
    employees.put(102, "Al");
    employees.put(203, "Hakim");
    employees.put(304, "Computer");
    employees.put(305, "Science");

    System.out.println("Total Employees: " + employees.getTotalEmployees());
  }
}
