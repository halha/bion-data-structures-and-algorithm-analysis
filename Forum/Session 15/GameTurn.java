/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "Queue" session 15 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// import packages yang dibutuhkan
import java.util.LinkedList;
import java.util.Queue;

// main class
public class GameTurn {

  public static void main(String[] args) {
    // inisialisasi variable queue dengan menggunakan linked list
    // tujuannya agar kita dapat mengakses method2 dalam linked list
    // untuk memudahkan pengolahan data
    Queue<String> turnQueue = new LinkedList<>();

    // inisialisasi max turn untuk simulasi berapa jumlah turn total untuk semua player
    int maxTurn = 15;
    int currentTurn = 1;

    // Testing menambahkan player dengan menggunakan method bawaan add()
    turnQueue.add("Player 1");
    turnQueue.add("Player 2");
    turnQueue.add("Player 3");

    // Testing simulasi play turn
    System.out.println("Player turn:");

    // agar simple, disini saya hanya melakukan looping sampai currentTurn mencapai maxTurn
    while (currentTurn != maxTurn) {
      // inisialisasi variable currentPlayer untuk menyimpan player yang sedang mendapat turn/giliran
      // disini menggunakan poll() karena poll digunakan untuk menghapus element pertama dalam list
      // dan karena poll juga me return element yang dihapus, makan hal ini juga bisa digunakan untuk
      // men set variable currentPlayer
      String currentPlayer = turnQueue.poll();

      // Tampilkan apa yang dilakukan player itu dalam turnnya
      // agar sederhana kita anggap saja setiap player hanya bisa menyerang
      System.out.println(currentPlayer + " use attck!");

      // Setelah turn selesai, currentPlayer tadi dimasukkan kembali ke dalam list sebagai element terakhir
      turnQueue.add(currentPlayer);
      // tambahkan 1 pada currentTurn karena player tersebut sudah selesai menggunakan turnnya (next turn)
      currentTurn++;
    }

    System.out.println("\nGame Ended");
  }
}
