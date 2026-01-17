import java.util.Scanner;

class Node {

  String nim, nama, jurusan;
  Node next;

  Node(String nim, String nama, String jurusan) {
    this.nim = nim;
    this.nama = nama;
    this.jurusan = jurusan;
    this.next = null;
  }
}

public class DBMahasiswa {

  static Node head = null;
  static int count = 0;
  static final int MAX = 5;

  static int nimValidation = 10;
  static String nimValidationCondition = "\\d{1," + nimValidation + "}";
  static int nameValidation = 30;
  static int jurusanValidation = 50;

  static void displayMenu() {
    System.out.println("\nMENU");
    System.out.println("1. Push Data Mahasiswa");
    System.out.println("2. Tampilkan Data (Sort NIM)");
    System.out.println("3. Pop Semua Data");
    System.out.println("4. Keluar");
    System.out.print("Pilih: ");
  }

  static void push(String nim, String nama, String jurusan) {
    Node baru = new Node(nim, nama, jurusan);
    if (head == null) {
      head = baru;
    } else {
      Node temp = head;
      while (temp.next != null) temp = temp.next;
      temp.next = baru;
    }
    count++;
  }

  static void inputData(Scanner in) {
    String nim = "";
    String name = "";
    String jurusan = "";

    boolean isNimValid = false;
    boolean isNameValid = false;
    boolean isJurusanValid = false;

    while (isNimValid == false) {
      System.out.print("NIM (max " + nimValidation + " angka): ");
      nim = in.nextLine();

      if (!nim.matches(nimValidationCondition)) {
        System.out.println("NIM tidak valid!");
      } else {
        isNimValid = true;
      }
    }

    while (!isNameValid) {
      System.out.print("Nama (max " + nameValidation + " karakter): ");
      name = in.nextLine();

      if (name.length() > nameValidation) {
        System.out.println("Nama terlalu panjang!");
      } else {
        isNameValid = true;
      }
    }

    while (!isJurusanValid) {
      System.out.print("Jurusan (max " + jurusanValidation + " karakter): ");
      jurusan = in.nextLine();

      if (jurusan.length() > jurusanValidation) {
        System.out.println("Jurusan terlalu panjang!");
      } else {
        isJurusanValid = true;
      }
    }

    push(nim, name, jurusan);
    System.out.println("Data berhasil ditambahkan.");
  }

  static void sortByNIM() {
    for (Node i = head; i != null; i = i.next) {
      for (Node j = i.next; j != null; j = j.next) {
        if (i.nim.compareTo(j.nim) > 0) {
          String tn = i.nim;

          i.nim = j.nim;
          j.nim = tn;

          String tna = i.nama;

          i.nama = j.nama;
          j.nama = tna;

          String tj = i.jurusan;

          i.jurusan = j.jurusan;
          j.jurusan = tj;
        }
      }
    }
  }

  static void tampil() {
    System.out.println("\n====================\n");

    if (head == null) {
      System.out.println("Data kosong.");
      System.out.println("\n====================");
      return;
    }

    sortByNIM();
    Node temp = head;

    while (temp != null) {
      System.out.println(temp.nim + " | " + temp.nama + " | " + temp.jurusan);
      temp = temp.next;
    }

    System.out.println("\n====================");
  }

  static void popAll() {
    head = null;
    count = 0;

    System.out.println("\n====================\n");
    System.out.println("Semua data berhasil dihapus.");
    System.out.println("\n====================");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int pilih;

    do {
      displayMenu();

      pilih = in.nextInt();
      in.nextLine();

      switch (pilih) {
        case 1:
          if (count >= MAX) {
            System.out.println("Data sudah mencapai batas maksimal (5).");
            break;
          }

          inputData(in);

          break;
        case 2:
          tampil();
          break;
        case 3:
          popAll();
          break;
      }
    } while (pilih != 4);

    System.out.println("Program selesai.");
  }
}
