import java.util.HashMap;

public class DataEmployee {

  private HashMap<Integer, String>[] table;

  public DataEmployee(int size) {
    table = new HashMap[size];
    for (int i = 0; i < size; i++) {
      table[i] = new HashMap<>();
    }
  }

  private int hash(int employeeId) {
    return employeeId % table.length;
  }

  public void put(int employeeId, String name) {
    int index = hash(employeeId);
    table[index].put(employeeId, name);
  }

  public int getTotalEmployees() {
    int count = 0;
    for (HashMap<Integer, String> list : table) {
      count += list.size();
    }
    return count;
  }
}
