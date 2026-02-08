/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "hashing" dan "hash function" session 28 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// import package LinkedList
import java.util.LinkedList;

// class untuk object player
class Player {

  // data yang disimpan player
  String username;
  int level;

  // constructor
  Player(String username, int level) {
    this.username = username;
    this.level = level;
  }
}

// class HashTable
class HashTable {

  // untuk menyimpan list hash
  LinkedList<Player>[] table;
  // untuk menyimpan size dari list hash yang akan digunakan
  int size;

  // constructor
  HashTable(int size) {
    // set global variable size dengan param size
    this.size = size;
    // buat new list pada table berdasarkan param size
    table = new LinkedList[size];

    // loop sebanyak size
    for (int i = 0; i < size; i++) {
      // pada setiap loop, item pada table dibuat linked list baru
      table[i] = new LinkedList<>();
    }
  }

  /*
    =================================================================
    function ini juga khusus untuk menjawab forum HASH FUNCTION
    =================================================================
  */
  // function untuk memanage penempatan item pada list hash
  int hash(String key) {
    int hash = 0;
    // prime atau prima disini digunakan menambahkan sedikit randomisasi
    // pada penempatan hash untuk menghindari collision
    int prime = 31;

    // loop sampai dengan panjang dari param key (di sini adalah username)
    for (int i = 0; i < key.length(); i++) {
      // perhitungan menggunakan prime untuk memberikan penempatan hash yang lebih unik
      hash = (hash * prime + key.charAt(i)) % size;
    }
    return hash;
  }

  // function untuk insert data baru
  void insert(Player player) {
    // index di sini menggunakan hasil hash dari username
    int index = hash(player.username);
    // setelah mendapatkan data index, assign pada element table yang sesuai
    // kemudian gunakan add method untuk menambahkan data ke dalam list
    table[index].add(player);
  }

  // function untuk search player
  Player search(String username) {
    // cari index dengan menggunakan method hash
    int index = hash(username);

    // looping ke semua list pada element table sesuai dengan index hash tadi
    for (Player p : table[index]) {
      // jika username ditemukan, kembalikan data player
      if (p.username.equals(username)) {
        return p;
      }
    }

    // jika tidak ketemu, kembalikan null
    return null;
  }
}

// main class
public class HashingPlayer {

  public static void main(String[] args) {
    // inisialisasi HashTable
    HashTable gamePlayers = new HashTable(10);

    // simulasi insert data 3 players
    gamePlayers.insert(new Player("KnightTest", 10));
    gamePlayers.insert(new Player("MageTest", 8));
    gamePlayers.insert(new Player("ArcherTest", 9));

    // simulasi search player
    Player p = gamePlayers.search("MageTest");

    // check apakah player ditemukan
    if (p != null) {
      // jika ketemu, tampilkan popup ketemu
      System.out.println(p.username + " Level: " + p.level);
    }
  }
}
