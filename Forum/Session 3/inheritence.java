/*
  NOTES : 
  - pada best practicenya seharusnya class ini dipisah pada filenya masing-masing
  karena ini hanya tugas untuk forum, saya hanya menggunakan satu file saja

  - saya juga biasanya membuat game menggunakan C#, tapi karena lacture notes menggunakan Java
  maka code ini juga menggunakan java

  - CODE INI SAYA GUNAKAN PADA FORUM "inheritence" DAN "encapsulation" NAMUN DENGAN PENJELASAN YANG BERBEDA
  SESUAI DENGAN JUDUL FORUM MASING-MASING
*/

// Di sini penjelasan code akan saya fokuskan kepada pembahasan INHERITENCE

// merupakan class parent yang digunakan sebagai template dasar class
class Weapon {

  // berisi variable apa saja yang dibutuhkan dari class ini
  protected String name;
  protected int damage;

  // merupakan fungsi constructor yang digunakan untuk memberi value pada variable saat class petama kali dipanggil
  public Weapon(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  // fungsi ketika weapon di set atau equip oleh player
  public void use() {
    // biasanya muncul semacam popup info ketika weapon di equip,
    // tapi di sini saya hanya menggunakan print untuk simulasi
    System.out.println("Using weapon :  " + name);
  }

  // fungsi untuk mendapatkan value damage (biasanya ketika akan menyerang atau
  // membandingkan damage weapon lama dan weapon baru yang didapat)
  public int getDamage() {
    return damage;
  }

  // fungsi untuk mendapatkan value name (biasanya ketika berada dalam dialog yang
  // membutuhkan nama weapon)
  public String getName() {
    return name;
  }
}

// sekarang buat subclass yang inherit dari class Weapon, disini class Sword
class Sword extends Weapon {

  public Sword() {
    // super digunakan untuk memanggil constructor function dari parent (dari class Weapon)
    super("Sword", 25);
  }

  // fungsi yang mengoverride fungsi use pada parent class (class Weapon)
  // tujuan override di sini adalah agar popup text lebih berasa immersive
  // karena setiap jenis weapon cara penggunaannya berbeda
  @Override
  public void use() {
    System.out.println(
      "Slashing enemy with sword! Dealing " + damage + " damage"
    );
  }
}

// Buat subclass lagi yang inherit dari class Weapon
class MagicStaff extends Weapon {

  // custom variable yang hanya dimiliki class MagicStaff (saat menyerang perlu mana)
  private int manaCost;

  // constructor dari class MagicStaff
  public MagicStaff() {
    // untuk memanggil constructor dari parent class (dari class Weapon)
    super("Magic Staff", 40);
    // untuk set mana
    this.manaCost = 20;
  }

  // fungsi yang mengoverride fungsi use pada parent class (class Weapon)
  // tujuan override di sini adalah agar popup text lebih berasa immersive
  // karena setiap jenis weapon cara penggunaannya berbeda
  @Override
  public void use() {
    String name = getName();

    System.out.println(
      "Using " +
      name +
      " to cast a spell with " +
      manaCost +
      " mana! Dealing " +
      damage +
      " damage"
    );
  }
}

// buat class Player yang nanti akan digunakan untuk simulasi
// player mengganti dan menggunakan weapon
class Player {

  // custom variable yang dimiliki oleh player
  private String name;
  private int health;
  // membuat custom variable yang mengambil dari class Weapon
  private Weapon weapon;

  // constructor dari class Player
  public Player(String name) {
    this.name = name;
    this.health = 100;
  }

  // fungsi saat player meng-equip sebuah weapon
  public void equipWeapon(Weapon weapon) {
    // set weapon ke variable weapon pada class ini
    this.weapon = weapon;

    // biasanya muncul popup animation saat equip weapon
    // tapi di sini saya hanya menggunakan println untuk simulasi
    System.out.println(name + " eqipping " + weapon.getName());
  }

  // fungsi player saat menyerang
  public void attack() {
    // mengecek apakah player menggunakan senjata
    if (weapon != null) {
      // jika player menggunakan senjata
      // maka jalankan fungsi use pada variable weapon (karena tipe data dari class weapon)
      weapon.use();
    } else {
      // jika player tidak punya senjata
      // munculkan popup bahwa player tidak menggunakan senjata
      System.out.println("Can't attack, no weapon equipped!");
    }
  }
}

// merupakan CLASS utama yang akan dieksekusi ketika file ini di run
class Main {

  // merupakan FUNGSI utama yang akan dieksekusi ketika file ini di run
  public static void main(String[] args) {
    // untuk inisialisasi variable yang menggunakan data type dari class Player
    Player player = new Player("Player Name");

    // untuk inisialisasi variable yang menggunakan data type dari class Sword dan MagicStaff
    Weapon sword = new Sword();
    Weapon staff = new MagicStaff();

    // untuk simulasi player meng-equip dan menggunakan weapon untuk menyerang
    player.equipWeapon(sword);
    player.attack();

    // hanya untuk spacing di console
    System.out.println();

    // untuk simulasi player mengubah senjata menjadi magic staff dan
    // menggunakan weapon untuk menyerang
    player.equipWeapon(staff);
    player.attack();
  }
}
