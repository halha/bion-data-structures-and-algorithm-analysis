/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "pseudocode algorithm" session 21 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

import java.util.*;

// class Room digunakan untuk inisialisasi variable dengan tipe data room dalam game
class Room {

  // variable yang dibutuhkan dalam Room Game
  String name;
  List<Room> neighbors = new ArrayList<>();

  // class cunstructor
  Room(String name) {
    this.name = name;
  }
}

public class NonLinearSearchInGame {

  static Set<Room> visited = new HashSet<>();

  public static boolean dfs(Room current, String target) {
    // cek apakah room yang dicari telah sesuai dengan room sekarang
    if (current.name.equals(target)) {
      // jika iya, maka return true (karena sudah ketemu)
      return true;
    }

    // jika tidak sesuai (atau belum pernah dikunjungi) tambahkan pada var visited
    // karena berarti room sudah dikunjungi
    visited.add(current);

    // lakukan perulangan terhadap variable neightbors pada var current
    for (Room r : current.neighbors) {
      // cek apakah r (element dalam array neighbors) belum pernah divisit
      if (!visited.contains(r)) {
        // jika kondisi terpenuhi, lakukan pengecekan secara rekursif
        // untuk mencari pada cabang dari ruangan tersebut
        if (dfs(r, target)) {
          // jika setelah rekursif selesai room ditemukan
          // return true
          return true;
        }
      }
    }

    // jika setelah proses looping dan rekursif room tidak ditemukan, return false
    return false;
  }

  public static void main(String[] args) {
    // inisialisasi var start untuk room pertama player memulao
    // dan room lain yaitu forest, cave dan treasure
    Room start = new Room("Start");
    Room forest = new Room("Forest");
    Room cave = new Room("Cave");
    Room treasure = new Room("Treasure");

    // assign variable sesuai dengan cabang atau neighbor yang diinginkan
    // start ditambahkan dengan forest (berarti disebelah ruang awal player terdapat forest)
    // forest ditambahkan dengan cave (berarti disebelah forest terdapat cave)
    // cave ditambahkan dengan tresure room (berarti disebelah cave terdapat tresure room)
    start.neighbors.add(forest);
    forest.neighbors.add(cave);
    cave.neighbors.add(treasure);

    // buat var found dengan tipe data boolean berisi pemanggilan function dfs
    // dengan mencari ruang tresure dari titik start player
    boolean found = dfs(start, "Treasure");
    // tampilkan apakah player berhasil menemukan tresure room dari variable2 room
    // yang telah kita buat tadi
    System.out.println("Treasure found? " + found);
  }
}
