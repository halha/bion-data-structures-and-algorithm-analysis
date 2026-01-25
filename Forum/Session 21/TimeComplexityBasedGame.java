/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "Time Complexity" session 21 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

import java.util.Random;
import java.util.Scanner;

// main class
public class TimeComplexityBasedGame {

  public static void main(String[] args) {
    // inisialisasi scanner untuk inpout player
    Scanner input = new Scanner(System.in);
    // inisialis variable dengan tipe data random
    Random rand = new Random();

    // inisialisasi angka
    int randomNumber = rand.nextInt(100) + 1;
    // inisialisai var guess untuk menyimpan input player
    int playerGuess = 0;

    // lakukan looping sampai player berhasil menembah random number
    while (playerGuess != randomNumber) {
      // tampilkan pesan untuk player menginput angka
      System.out.print("Input number (1-100): ");
      playerGuess = input.nextInt();

      // cek apakah player berhasil menebak angka
      if (playerGuess == randomNumber) {
        // jika iya tampilkan pesan win
        System.out.println("You guess correctly!");
      } else if (playerGuess < randomNumber) {
        // buat kondisi lagi apakah number inputan player lebih kecil dari random number
        // jika iya tampilkan pesan bahwa angka yang diinputkan terlalu kecil
        System.out.println("Number too low");
      } else {
        // jika kondisi2 di atas tidak terpenuhi
        // makan tampilkan pesan bahwa angka yang diinputkan terlalu besar
        System.out.println("Number too high");
      }
    }

    // close input saat program selesai untuk best practice
    input.close();
  }
}
