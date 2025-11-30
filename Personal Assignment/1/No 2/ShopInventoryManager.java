import java.util.Scanner;

class Barang {

  public String nama;
  public int jumlahStok;
  public double harga;

  public Barang(String nama, int jumlahStok, double harga) {
    this.nama = nama;
    this.jumlahStok = jumlahStok;
    this.harga = harga;
  }
}

public class ShopInventoryManager {

  private static Barang[] inventaris = new Barang[10];

  public static void GetListBarang() {
    System.out.println("Inventaris Toko:");

    for (int i = 0; i < inventaris.length; i++) {
      if (inventaris[i] != null) {
        System.out.println(
          (i + 1) +
          ". Nama: " +
          inventaris[i].nama +
          ", Jumlah Stok: " +
          inventaris[i].jumlahStok +
          ", Harga: " +
          (int) inventaris[i].harga
        );
      }
    }
  }

  public static void AddBarang(Barang barang) {
    for (int i = 0; i < inventaris.length; i++) {
      if (inventaris[i] == null) {
        inventaris[i] = barang;
        return;
      }
    }

    System.out.println("Error: inventory full, can't add barang.");
  }

  public static int checkIsBarangExist(String nama) {
    for (int i = 0; i < inventaris.length; i++) {
      if (inventaris[i] != null && inventaris[i].nama.equalsIgnoreCase(nama)) {
        return i;
      }
    }

    return -1;
  }

  public static void updateStok(String nama, int jumlahBaru) {
    int barangIndex = checkIsBarangExist(nama);

    if (barangIndex != -1) {
      inventaris[barangIndex].jumlahStok = jumlahBaru;

      System.out.println();
      System.out.println("Successfully update stock!");
      System.out.println();
      return;
    }

    System.out.println("Barang not found.");
  }

  public static void cariBarang(String nama) {
    int barangIndex = checkIsBarangExist(nama);

    if (barangIndex != -1) {
      System.out.println("Hasil pencarian:");
      System.out.println(
        "Nama: " +
        inventaris[barangIndex].nama +
        ", Jumlah Stok: " +
        inventaris[barangIndex].jumlahStok +
        ", Harga: " +
        (int) inventaris[barangIndex].harga
      );
    } else {
      System.out.println("Barang not found.");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    AddBarang(new Barang("Coffee Sachet", 50, 3000));
    AddBarang(new Barang("Tea (small box)", 30, 12000));
    AddBarang(new Barang("Matcha Sachet", 20, 7000));
    AddBarang(new Barang("Air", 100, 2500));

    GetListBarang();
    System.out.println();

    System.out.print("Masukkan nama barang yang ingin diupdate: ");
    String namaUpdate = sc.nextLine();

    System.out.print("Masukkan jumlah stok baru: ");
    int stokBaru = sc.nextInt();
    sc.nextLine();

    updateStok(namaUpdate, stokBaru);

    System.out.println("\nInventaris setelah diupdate:");
    GetListBarang();

    System.out.print("\nMasukkan nama barang yang dicari: ");
    String namaCari = sc.nextLine();

    cariBarang(namaCari);
  }
}
