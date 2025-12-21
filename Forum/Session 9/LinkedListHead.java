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

  // function untuk insert pada head
  void insertAtHead(String playerName) {
    // inisialiasi node baru dengan parameter playerName (tanda jika terdapat player baru yang join)
    Node newNode = new Node(playerName);

    // karen insert ke head, jadi set next pada newNode menjadi head lama
    // kemudian set head lama menjadi newNode (jadi player baru sekarang ada di depan/head)
    newNode.next = head;
    head = newNode;
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

// main class
public class LinkedListHead {

  public static void main(String[] args) {
    // panggil function simulationArena
    simulationArena();
  }

  public static void simulationArena() {
    // inisialisasi list player dalam arena (atau linked list yang dibuat tadi)
    PlayerList arena = new PlayerList();

    // Simulasi menambahkan new player atau player baru join arena
    arena.insertAtHead("Hammam (Knight)");
    arena.insertAtHead("Al (Mage)");
    arena.insertAtHead("Hakim (Assassin)");

    // panggil function displayPlayers pada variable arena
    // karena insertnya melalui head, jadi list yang ditampilkan
    // akan menghasilkan urutan dari player terkhir yang join dalam arena
    arena.displayPlayers();
  }
}
