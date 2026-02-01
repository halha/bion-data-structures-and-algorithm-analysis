/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "fungsi rekursif" session 22 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// main class
public class RecursiveGame {

  // fungsi untuk menghitung exp based on jumlah monster
  static int calculateExp(int monster) {
    // kondisi basis dimana jika jumlah monster == 0, berhentikan function
    // atau return default value (disini 0 exp)
    if (monster == 0) {
      return 0;
    }

    // looping menggunakan rekursif dengan exp current monster + exp next monster
    return 100 + calculateExp(monster - 1);
  }

  public static void main(String[] args) {
    // var dummy untuk testing berapa monster untuk simulasi
    int monsterCount = 5;

    // variable wadah untuk perhitungan total exp
    int expTotal = calculateExp(monsterCount);

    // tampilan yang dilihat player
    System.out.println("Player has slain " + monsterCount + " monsters");
    System.out.println("Total EXP : " + expTotal);
  }
}
