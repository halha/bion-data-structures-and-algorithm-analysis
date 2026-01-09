/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "push and pop operation in doubly linked list" session 14 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// Class Node merepresentasikan satu item dalam inventory
class Node {

  String itemName; // Nama item dalam game
  Node prev; // Pointer ke node sebelumnya
  Node next; // Pointer ke node berikutnya

  // Constructor Node
  Node(String itemName) {
    this.itemName = itemName;
    this.prev = null;
    this.next = null;
  }
}

// class Inventory ini adalah class yang akan digunakan untuk
// menerapkan konsep doubly linked list
class Inventory {

  // berisi variable yang dibutuhkan oleh inventory
  // Node head untuk item pertama
  // Node tail untuk item terakhir
  Node head;
  Node tail;

  // Constructor untuk class Inventory
  Inventory() {
    head = null;
    tail = null;
  }

  // functiun untuk add item di awal inventory
  void addItemAtFront(String itemName) {
    // inisialisasi variable node baru (nNode) dengan mengggunakan itemName sebagai params
    Node nNode = new Node(itemName);

    // check apakah var head masih kosong
    if (head == null) {
      // jika kosong, set head dan tail nya menjadi node baru tadi (karena list masih kosong)
      head = tail = nNode;
    } else {
      // jika head tidak kosong, set prev pada head menjadi node baru
      head.prev = nNode;
      // kemudian set next pada node baru menjadi head
      nNode.next = head;
      // dan terakhir, set head menjadi node baru
      head = nNode;
      // sehingga node baru atau item baru tersebut berhasil ditambahkan pada awal list
    }
  }

  // functiun untuk add item di akhir inventory
  void addItemAtBack(String itemName) {
    // inisialisasi variable node baru (nNode) dengan mengggunakan itemName sebagai params
    Node nNode = new Node(itemName);

    if (head == null) {
      // jika kosong, set head dan tail nya menjadi node baru tadi (karena list masih kosong)
      head = tail = nNode;
    } else {
      // jika head tidak kosong, set next pada tail menjadi node baru
      tail.next = nNode;
      // kemudian set prev pada node baru menjadi tail
      nNode.prev = tail;
      // dan terakhir, set tail menjadi node baru
      tail = nNode;
      // sehingga node baru atau item baru tersebut berhasil ditambahkan pada akhir list
    }
  }

  // function untuk menghapus item dari tail
  void removeItem() {
    // jika isi tail kosong (list masih kosong), cukup return saja, tidak ada lanjutan function
    // untuk opsi lain terutama dalam kasus nyata game
    // cukup dengan non active kan tombol remove item
    // atau beri alert bahwa tidak ada item yang bisa dihapus
    if (tail == null) return;

    // variable removed berisi item name dari tail
    // hanya digunakan sebagai text yang di display ketika item berhasil dihaopus
    String removed = tail.itemName;

    if (head == tail) {
      head = tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
    }

    System.out.println("====================");
    System.out.println(removed + " removed from inventory.");
    System.out.println("====================");
    System.out.println();
  }

  // function untuk menghapus item dari head
  void removeItemFront() {
    if (head == null) return;

    String removed = head.itemName;

    head = head.next;
    if (head != null) head.prev = null;
    else tail = null;

    System.out.println("====================");
    System.out.println(removed + " removed from inventory.");
    System.out.println("====================");
    System.out.println();
  }

  // function untuk display item pada inventory
  void displayItem() {
    // inisialisasi variable node current yang berisi variable head
    // variable ini akan digunakan untuk kondisi looping
    Node current = head;

    System.out.println("===== Inventory =====");

    // looping variable current sampai isi dari variable current tersebut adalah kosong
    while (current != null) {
      // setiap loop, tampilkan item pada variable current
      // untuk format tampilan display disini saya pakai sekedar list sederhana
      System.out.println(current.itemName);

      // set current menjadi next node pada current agar dapat melanjutkan looping (ke item selanjutnya)
      current = current.next;
    }
  }
}

// class Main yang akan digunakan
public class DoublyLinkedListPushPop {

  public static void main(String[] args) {
    // inisialisasi class inventory dengan tipe data dari class Inventory
    Inventory inventory = new Inventory();

    // tambahkan item sword ke depan list
    inventory.addItemAtFront("Sword");
    // tambahkan item shield ke belekang list
    inventory.addItemAtBack("Shield");
    // tambahkan item potion ke depan list
    inventory.addItemAtFront("Potion");

    // panggil displayItem untuk melihat list item yang telah ditambahkan di inventory
    // jika benar, urutannya seharusnya potion, sword, shield
    inventory.displayItem();

    System.out.println();

    // panggil function removeitem untuk menghapus item terakhir
    inventory.removeItem();

    // jika benar seharusnya item shield sudah tidak ada
    inventory.displayItem();

    System.out.println();

    // panggul function removeItemFront untuk menghapus item pertama
    inventory.removeItemFront();

    // jika benar, seharusnya sekarang item potion sudah tidak ada juga
    inventory.displayItem();
  }
}
