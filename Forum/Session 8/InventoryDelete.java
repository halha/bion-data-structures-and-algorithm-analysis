/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "operasi penghapusan pada array" session 8 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena lacture notes menggunakan Java
  maka code ini juga menggunakan java
*/

// untuk import scanner agar dapat mengambil input user / player
import java.util.Scanner;

// main class : sama dengan nama file
public class InventoryDelete {

  // Function untuk view list item di dalam inventory
  public static void viewInventory(String[] inventory) {
    System.out.println("\n===== Inventory: =====");

    // looping semua item pada array inventory untuk ditampilkan pada user / player
    for (int i = 0; i < inventory.length; i++) {
      System.out.println("Slot " + i + ": " + inventory[i]);
    }
  }

  // Function untuk drop item (operasi penghapusan pada array)
  // function mengembalikan array of string
  static String[] dropItem(String[] inventory, String item) {
    // array untuk update inventory baru
    // karena operasi delete, maka panjang array nya dikurangi 1
    String[] nInventory = new String[inventory.length - 1];
    // variable untuk menyimpan index dari item yang akan di drop / delete
    int idxDelete = -1;
    // untuk mengecek apakah item yang di drop / delete ada dalam inventory
    boolean haveItem;

    // looping semua item pada inventory dari paramenter
    for (int i = 0; i < inventory.length; i++) {
      // cek apakah item yang sedang di loop sama dengan item yang diinput oleh player / user
      if (inventory[i].equalsIgnoreCase(item)) {
        // jika item sama dengan yang diinput user / player,
        // maka set idxDelete sesuai dengan index yang sedang di loop
        idxDelete = i;
        // berhentikan looping karena item sudah ketemu
        break;
        // cek apakah i lebih kecil dari panjang inventory baru
        // untuk menghindari error out of bound
      } else if (i < nInventory.length) {
        // jika item tidak sama, maka item index i pada inventory baru
        // sama dengan item index i pada inventory parameter
        nInventory[i] = inventory[i];
      }
    }

    // cek apakah setelah loop item tidak ditemukan
    if (idxDelete == -1) {
      // tampilkan pesan bahwa item tidak ditemukan
      System.out.println("\nItem is not in the inventory.");
      // return inventory parameter (karena tidak ada perubahan)
      return inventory;
    }

    // looping item mulai dari idxDelete ke akhir array untuk menset array inventory baru
    for (int i = idxDelete; i < inventory.length - 1; i++) {
      // set item pada index i di inventory baru
      // sama dengan item pada index i + 1 pada inventory parameter
      // (karena item pada idxDelete didrop / dihapus, jadi i + 1 berperan sebagai pergeseran item kedepan)
      nInventory[i] = inventory[i + 1];
    }

    // tampilkan pesan bahwa item berhasil didrop / dihapus
    System.out.println("\nDropped item " + inventory[idxDelete] + "!");
    // return inventory baru
    return nInventory;
  }

  public static void main(String[] args) {
    // array inventory
    // untuk simulasi hapus / drop item, anggap inventory sudah ada isinya
    String[] inventory = { "Potion", "Sword", "Shield", "Bow", "Staff" };

    // untuk inisialisasi scanner agar dapat mengambil input user / player
    Scanner input = new Scanner(System.in);

    // panggil function viewInventory untuk melihat list item dalam inventory
    viewInventory(inventory);

    // Input item yang ingin di-drop
    System.out.print("Type item to drop : ");
    String itemDrop = input.nextLine();

    // insialisasi variable nInventory (inventory baru) yang isinya adalah
    // hasil dari function dropItem
    String[] nInventory = dropItem(inventory, itemDrop);

    // panggil function viewInventory dengan nInventory sebagai parameter
    // untuk melihat inventory setelah operasi penghapusan dilakukan
    viewInventory(nInventory);

    // untuk close input sebelum program selesai
    input.close();
  }
}
