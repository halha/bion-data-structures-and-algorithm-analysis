import java.util.ArrayList;

class TestArrayList {

  private ArrayList<Integer> numbers;

  public TestArrayList() {
    this.numbers = new ArrayList<>();
    System.out.println("Initializing....");
  }

  public void GetList() {
    System.out.println("===== LIST =====");

    for (int num : numbers) {
      System.out.println(num);
    }

    System.out.println("================");
  }

  public void AddNumber(int num) {
    System.out.println("Adding number " + num + " to the list...");

    numbers.add(num);

    System.out.println("Number " + num + " succesfully added to the list!");
  }

  public void SearchByIndex(int index) {
    if (numbers.size() <= index) {
      System.out.println("Number not found!");
    } else {
      System.out.println(
        "Number on index " + index + " is " + numbers.get(index)
      );
    }
  }

  public boolean SearchByNumber(int num) {
    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) == num) {
        System.out.println("Found number " + num + " on index " + i);
        return true;
      }
    }

    System.out.println("Number " + num + " not found!");
    return false;
  }

  public void DeleteNumber(int num) {
    boolean isNumberExist = SearchByNumber(num);

    if (isNumberExist) {
      numbers.remove(Integer.valueOf(num));
      System.out.println("Number " + num + " have been successfully removed!");
    } else {
      System.out.println(
        "Can't delete number! The number " + num + " doesn't exist!"
      );
    }
  }
}

class Main {

  public static void main(String[] args) {
    TestArrayList test = new TestArrayList();

    test.AddNumber(10);
    test.AddNumber(20);

    System.out.println();

    test.GetList();

    System.out.println();

    test.SearchByIndex(0);
    test.SearchByIndex(2);

    System.out.println();

    test.SearchByNumber(20);
    test.SearchByNumber(30);

    System.out.println();

    test.DeleteNumber(10);
    test.DeleteNumber(30);

    System.out.println();

    test.GetList();
  }
}
