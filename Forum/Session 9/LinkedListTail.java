// class ini adalah dasar node untuk linked list single
// dalam case ini, nodenya adalah player dalam game
class Node {

  // variable yang dibutuhkan oleh player (bisa jadi ada level, job, etc tapi di sini saya palai name saja)
  String playerName;
  // variable digunakan untuk pointer ke next node
  Node next;

  // function constructor
  Node(String playerName) {
    // set awal ketika class dipanggil
    // untuk next dibuat null karena node berikutnya masih kosong
    this.playerName = playerName;
    this.next = null;
  }
}

// class untuk management list player (atau sebagai linked listnya)
class PlayerList {

  // variable node digunakan untuk menyimpan head dari linked list
  Node head;

  // function constructor
  PlayerList() {
    this.head = null;
  }

  // function untuk insert pada tail
  void insertAtTail(String playerName) {
    // inisialiasi node baru dengan parameter playerName (tanda jika terdapat player baru yang join)
    Node newNode = new Node(playerName);

    // karena insert dari tail, terdapat possibility dimana head masih kosong
    // jadi diperlukan pengecekan kondisi
    if (head == null) {
      // jika head masih null, set head menjadi newNode
      head = newNode;

      // stop function dengan return
      // karena jumlah player hanya satu (tidak perlu proses berikutnya)
      return;
    }

    // next process ketika total node player lebih dari satu atau head tidak null
    // inisialisasi node current dan set current menjadi head
    Node current = head;

    // lakukan loop dengan while dimana loop dilakuakn sampai isi
    // current.next adalah null (tidak ada node berikutnya)
    while (current.next != null) {
      // set current menjadi node selanjutnya pada var current.next
      current = current.next;
    }

    // setelah mendapatkan node current next yang kosong (atau null)
    // pada var current, set current.next menjadi newNode (node yang baru tadi)
    // sehingga node baru tersebut berada di ujung list (atau tail)
    current.next = newNode;
  }

  // function untuk display list player yang join dalam game
  void displayPlayers() {
    // inisialisasi variable node yang berisi head
    Node current = head;

    System.out.println("========== List Player in Arena ==========");

    // loop semua head dengan menggunakan while dimana looping akan terus dilakukan
    // sampai variable current adalah null (berarti tidak ada node lagi)
    while (current != null) {
      System.out.println("- " + current.playerName);

      // set current ke next agar looping berlanjut ke node selanjutnya
      current = current.next;
    }
  }
}

// Class utama
public class LinkedListTail {

  public static void main(String[] args) {
    simulationArena();
  }

  public static void simulationArena() {
    // inisialisasi list player dalam arena (atau linked list yang dibuat tadi)
    PlayerList arena = new PlayerList();

    // Simulasi menambahkan new player atau player baru join arena
    arena.insertAtTail("Hammam (Knight)");
    arena.insertAtTail("Al (Mage)");
    arena.insertAtTail("Hakim (Assassin)");

    // panggil function displayPlayers pada variable arena
    // karena insertnya melalui tail, jadi list yang ditampilkan
    // akan menghasilkan urutan dari player awal yang join dalam arena
    arena.displayPlayers();
  }
}
