import java.util.Scanner;

class Barang {

  public String nama;
  public int jumlahStok;
  public int harga;

  public Barang(String nama, int jumlahStok, int harga) {
    this.nama = nama;
    this.jumlahStok = jumlahStok;
    this.harga = harga;
  }
}

public class ShopInventoryManager {

  public static void GetListBarang(Barang[] listBarang) {
    System.out.println("Inventaris Toko:");

    for (int i = 0; i < listBarang.length; i++) {
      if (listBarang[i] != null) {
        System.out.println(
          (i + 1) +
          ". Nama: " +
          listBarang[i].nama +
          ", Jumlah Stok: " +
          listBarang[i].jumlahStok +
          ", Harga: " +
          listBarang[i].harga
        );
      }
    }
  }

  public static void AddBarang(Barang barang, Barang[] listBarang) {
    for (int i = 0; i < listBarang.length; i++) {
      if (listBarang[i] == null) {
        listBarang[i] = barang;
        return;
      }
    }

    System.out.println("Error: inventory full, can't add barang.");
  }

  public static int checkIsBarangExist(Barang[] listBarang, String nama) {
    for (int i = 0; i < listBarang.length; i++) {
      if (listBarang[i] != null && listBarang[i].nama.equalsIgnoreCase(nama)) {
        return i;
      }
    }

    return -1;
  }

  public static void updateStok(Barang[] listBarang, String nama, int newStok) {
    int barangIndex = checkIsBarangExist(listBarang, nama);

    if (barangIndex != -1) {
      listBarang[barangIndex].jumlahStok = newStok;

      System.out.println();
      System.out.println("Successfully update stock!");
      System.out.println();
      return;
    }

    System.out.println("Barang not found.");
  }

  public static void searchBarang(Barang[] listBarang, String nama) {
    int barangIndex = checkIsBarangExist(listBarang, nama);

    if (barangIndex != -1) {
      System.out.println("Hasil pencarian:");
      System.out.println(
        "Nama: " +
        listBarang[barangIndex].nama +
        ", Jumlah Stok: " +
        listBarang[barangIndex].jumlahStok +
        ", Harga: " +
        listBarang[barangIndex].harga
      );
    } else {
      System.out.println("Barang not found.");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Barang[] listBarang = new Barang[10];

    AddBarang(new Barang("Coffee Sachet", 50, 3000), listBarang);
    AddBarang(new Barang("Tea (small box)", 30, 12000), listBarang);
    AddBarang(new Barang("Matcha Sachet", 20, 7000), listBarang);
    AddBarang(new Barang("Air", 100, 2500), listBarang);

    GetListBarang(listBarang);
    System.out.println();

    System.out.print("Masukkan nama barang yang ingin diupdate: ");
    String namaUpdate = sc.nextLine();

    System.out.print("Masukkan jumlah stok baru: ");
    int stokBaru = sc.nextInt();
    sc.nextLine();

    updateStok(listBarang, namaUpdate, stokBaru);

    System.out.println("\nInventaris setelah diupdate:");
    GetListBarang(listBarang);

    System.out.print("\nMasukkan nama barang yang dicari: ");
    String namaCari = sc.nextLine();

    searchBarang(listBarang, namaCari);
  }
}
