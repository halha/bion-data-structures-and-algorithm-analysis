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

    System.out.println("Error: inventory full, can't add barang");
  }

  public static void main(String[] args) {
    Barang[] listBarang = new Barang[10];

    AddBarang(new Barang("Coffee Sachet", 50, 3000), listBarang);
    AddBarang(new Barang("Tea (small box)", 30, 12000), listBarang);
    AddBarang(new Barang("Matcha Sachet", 20, 7000), listBarang);
    AddBarang(new Barang("Air", 100, 2500), listBarang);

    GetListBarang(listBarang);
  }
}
