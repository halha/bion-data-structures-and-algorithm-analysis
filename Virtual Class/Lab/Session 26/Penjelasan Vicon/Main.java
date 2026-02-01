public class Main {

  public static void main(String[] args) {
    HashTable ht = new HashTable(5);

    ht.insert(100, "Ham");
    ht.insert(86, "mam");
    ht.insert(23, "Al");
    ht.insert(73, "Ha");
    ht.insert(65, "kim");

    System.out.println("========== BEFORE DELETE ==========");
    ht.display();
    ht.delete(86);

    System.out.println("\n========== AFTER DELETE ==========");
    ht.display();

    System.out.println("Searching key 86 : " + ht.search(86));
    System.out.println("Searching key 100 : " + ht.search(100));

    System.out.println("\n========== BEFORE UPDATE ==========");
    ht.display();
    ht.update(100, "Hammam");

    System.out.println("\n========== AFTER UPDATE ==========");
    ht.display();

    System.out.println("Searching key 100 : " + ht.search(100));
  }
}
