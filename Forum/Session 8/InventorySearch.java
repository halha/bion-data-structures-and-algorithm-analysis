/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "operasi pencarian pada array" session 8 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena lacture notes menggunakan Java
  maka code ini juga menggunakan java
*/

// untuk import scanner agar dapat mengambil input user / player
import java.util.Scanner;

// main class : sama dengan nama file
public class InventorySearch {

  // array inventory
  // untuk simulasi hapus / drop item, anggap inventory sudah ada isinya
  public static String[] inventory = {
    "Potion",
    "Sword",
    "Shield",
    "Bow",
    "Staff",
  };

  // Function untuk view list item di dalam inventory
  public static void viewInventory() {
    System.out.println("\n===== Inventory: =====");

    // looping semua item pada array inventory untuk ditampilkan pada user / player
    for (int i = 0; i < inventory.length; i++) {
      System.out.println("Slot " + i + ": " + inventory[i]);
    }
  }

  // fungsi untuk operasi search pada array
  public static void searchItem(String item) {
    // looping setiap item dalam array inventory
    for (int i = 0; i < inventory.length; i++) {
      // cek apalkah item yang dicari melalui input sama dengan item yang sedang di loop
      if (inventory[i].equalsIgnoreCase(item)) {
        // jika sama atau sesuai, maka tampilkan bahwa item ada dalam inventory
        System.out.println("Item \"" + inventory[i] + "\" found at slot " + i);

        // return untuk menghentikan function (karena item sudah ketemu, fungsi tidak perlu dilanjutkan)
        return;
      }
    }

    // jika loop selesai dan item tidak ditemukan, tampilkan bahwa item tidak ditemukan
    System.out.println("Item \"" + item + "\" is not in the inventory.");
  }

  public static void main(String[] args) {
    // untuk inisialisasi scanner agar dapat mengambil input user / player
    Scanner input = new Scanner(System.in);

    // panggil function viewInventory untuk melihat list item dalam inventory
    viewInventory();

    // untuk memberi konteks apa yang perlu user / player input
    System.out.print("Search item in the inventory : ");
    // variable untuk menyimpan input user / player
    // karena input berupa string, maka menggunakan nextLine untuk mendapatkan value inputnya
    String searchedItem = input.nextLine();

    // panggil function searchItem setelah user / player input untuk melakukan pencarian item
    searchItem(searchedItem);

    // untuk close input sebelum program selesai
    input.close();
  }
}
