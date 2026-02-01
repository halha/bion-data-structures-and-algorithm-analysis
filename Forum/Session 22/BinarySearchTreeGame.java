/*
  NOTES : 
  - code ini saya gunakan untuk menjawab forum "binary search tree" session 22 matkul Data Structures and Algorithm Analysis

	- case yang saya gunakan akan berhubungan dengan game karena saya biasa dengan logika game dan case-case dari game
	lebih mudah untuk saya jelaskan

  - saya biasanya membuat game menggunakan C#, tapi karena matkul menggunakan Java
  maka code ini juga menggunakan java
*/

// class untuk Node
class Node {

  int score;
  Node left;
  Node right;

  // constructor
  Node(int score) {
    this.score = score;
    left = null;
    right = null;
  }
}

// Class untuk binary search tree
class BinarySearchTree {

  // variable node untuk menyimpan data root
  Node root;

  // contructor
  BinarySearchTree() {
    root = null;
  }

  // Function untuk insert ke variable root
  void insert(int score) {
    root = insertRec(root, score);
  }

  // Function untuk insert secara recursive
  // dengan kondisi pengecekan value besar atau kecil
  Node insertRec(Node root, int score) {
    // jika root kosong (data masih kosong)
    // buat new node untuk var root
    // kemudian return root tersebut
    if (root == null) {
      root = new Node(score);
      return root;
    }

    // jika data tidak kosong, cek apakah score baru
    // lebih kecil dari score pada root
    if (score < root.score) {
      // jika kondisi terpenuhi, insert score tersebut di sebelah kiri
      root.left = insertRec(root.left, score);
    } else if (score > root.score) {
      // jika tidak dan score tersebut lebih besar dari score pada root
      // insert score ke sebelah kanan
      root.right = insertRec(root.right, score);
    }

    // setelah pengecekan kondisi tadi dan recursif telah selesai
    // return root
    return root;
  }

  // function untuk searching score
  boolean search(int score) {
    return searchRec(root, score);
  }

  // function searching secara recursive
  boolean searchRec(Node root, int score) {
    // jika root kosong, return false (data kosong)
    if (root == null) {
      return false;
    }

    // jika root == score, return true (data ketemu)
    if (root.score == score) {
      return true;
    }

    // jika score yg dicasri lebih kecil dari score pada root
    // recursive pencarian ke arah kiri dan return apakah ketemu atau tidak
    if (score < root.score) {
      return searchRec(root.left, score);
    }

    // jika kondisi diatasnya tidak terpenuhi
    // recursive pencarian ke arah kanan dan return apakah ketemu atau tidak
    return searchRec(root.right, score);
  }

  // function untuk display secara urut
  void inorder() {
    inorderRec(root);
  }

  // function recursive untuk menampilkan element dalam list
  // secara urut dari kiri ke kanan
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.score + " ");
      inorderRec(root.right);
    }
  }
}

// Main class untuk simulasi
public class BinarySearchTreeGame {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();

    // Insert score pemain
    bst.insert(50);
    bst.insert(30);
    bst.insert(70);
    bst.insert(20);
    bst.insert(40);
    bst.insert(60);
    bst.insert(80);

    System.out.print("PLayer score (low to high): ");
    bst.inorder();

    System.out.println(
      "\nCheck if there any 60 score in the list? " + bst.search(60)
    );
    System.out.println(
      "Check if there any 25 score in the list? " + bst.search(25)
    );
  }
}
