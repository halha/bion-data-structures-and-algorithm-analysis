/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "Stack" session 15 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// import packages yang dibutuhkan
import java.util.Stack;

// main class
public class UndoTurnMove {

  public static void main(String[] args) {
    // inisialisasi variable moveStack dengan menggunakan tipe data stack
    Stack<String> moveStack = new Stack<>();

    // Testing player moving
    moveStack.push("Position (1,0)");
    moveStack.push("Position (1,1)");
    moveStack.push("Position (2,1)");
    moveStack.push("Position (2,2)");

    // untuk testing sampai stack kosong, akan saya lakukan dengan me looping
    // semua element dalam stack sampai stack tersebut kosong
    while (!moveStack.isEmpty()) {
      // Simulasi undo movement dengan menggunakan pop()
      // disini pop digunakan untuk menghapus element terakhir pada list stack
      // dan karena pop sendiri me return element yang dihapus
      // hal ini dapat digunakan juga untuk menampilkan element yang dihapus
      System.out.println("Undo: " + moveStack.pop());

      // Simulasi untuk mengecek posisi saat ini
      // untuk menghindari error saat stack sedang kosong
      // perlu dilakukan pengecekan kondisi apakah moveStack kosong
      if (!moveStack.isEmpty()) {
        // jika tidak kosong, maka tampilkan posisi saat ini dengan menggunakan method peek()
        // di sini pop digunakan untuk melihat element terakhir dalam list moveStack
        System.out.println("Tile now: " + moveStack.peek() + "\n");
      } else {
        // jika moveStack kosong, tampilkan pesan default
        // di sini berarti player berada pada posisi default yaitu (0, 0)
        System.out.println("Tile now: Position (0,0)\n");
      }
    }
  }
}
