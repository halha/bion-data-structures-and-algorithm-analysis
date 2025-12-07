/*
  NOTES : 
    - case yang saya gunakan sama untuk forum "array" dan "linked list" jadi secara structure code sama
  namun implementasinya berbeda sesuai dengan nama forum masing-masing

  - code ini saya gunakan untuk menjawab forum "array" session 7 matkul Data Structures and Algorithm Analysis

  - saya biasanya membuat game menggunakan C#, tapi karena lacture notes menggunakan Java
  maka code ini juga menggunakan java
*/

// module digunakan untuk mengambil input user or player
import java.util.Scanner;

// class utama untuk bag inventory
public class BagInventory {

  // inisialisasi array untuk menyimpan item pada bag
  public static String[] inventory = new String[5];

  // fungsi untuk get action menu
  public static void getActionMenu() {
    System.out.println("=== BAG INVENTORY ===");
    System.out.println("1. Add Item");
    System.out.println("2. Check Inventory");
    System.out.println("3. Close Bag");
    System.out.print("Choose option: ");
  }

  // fungsi untuk add item pada bag,
  // index digunakan untuk menentukan posisi item yang akan ditambahkan pada array
  // input untuk scanner input
  public static int addItem(int index, Scanner input) {
    // untuk mengecek apakah bag sudah full
    if (index >= inventory.length) {
      // jika full, beri alert bahwa bag is full dan tidak bisa add item
      getAlert("Bag full! Can't add item!");
      return index;
    } else {
      // jika bag is not full, input item yang ingin ditambahkan
      System.out.print("Masukkan nama item: ");
      // hanya untuk buffer input
      String item = input.nextLine();

      // add item sesuai dengan index slot item yang kosong
      inventory[index] = item;
      index++;

      // munculkan popup alert kalau item berhasil ditambahkan
      getAlert("Item added!");
    }

    return index;
  }

  // fungsi untuk mengecek isi bag
  public static void checkBag() {
    System.out.println("\n==== BAG CONTENT ====");

    // untuk looping isi dari array
    for (int i = 0; i < inventory.length; i++) {
      // cek apakah terdapat item pada slot i
      if (inventory[i] != null) {
        // jika ada, tampilkan slot item
        System.out.println((i + 1) + ". " + inventory[i]);
      } else {
        // jika kosong, tampilkan slot kosong
        System.out.println((i + 1) + ". [EMPTY]");
      }
    }

    // untuk spacing
    System.out.println();
  }

  // fungsi untuk menutup tas
  public static void closeBag() {
    // normalnya dalam game, di sini digunakan untuk melakukan animasi untuk menutup tas
    // dan kembali ke normal gameplay
    // di sini saya hanya sekedar menampilkan text closing bag
    System.out.println("\nClosing bag...");
  }

  // fungsi util untuk menampilkan popup agar tidak perlu copas code / duplikasi code
  public static void getAlert(String message) {
    System.out.println("\n=====================");
    System.out.println("\n" + message + "\n");
    System.out.println("=====================\n");
  }

  public static void main(String[] args) {
    // inisialisasi variable scanner untuk mengambil input user / player
    Scanner input = new Scanner(System.in);

    // int pilih digunakan untuk menyimpan pilihan user pada action menu
    int pilih;
    // untuk indikasi slot item yang akan digunakan untuk add item
    int index = 0;

    // untuk looping user / player action saat membuka tas
    // end program saat user pilih opsi 3
    do {
      getActionMenu();

      // untuk input buffer
      pilih = input.nextInt();
      input.nextLine();

      // untuk mengarahkan action sesuai opsi yang dipilih user / player
      switch (pilih) {
        case 1:
          index = addItem(index, input);
          break;
        case 2:
          checkBag();
          break;
        case 3:
          closeBag();
          break;
        default:
          // jika user memilih opse diluar case
          getAlert("Option invalid!");
      }
    } while (pilih != 3);

    // untuk close
    input.close();
  }
}
