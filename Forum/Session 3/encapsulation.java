/*
  NOTES : 
  - pada best practicenya seharusnya class ini dipisah pada filenya masing-masing
  karena ini hanya tugas untuk forum, saya hanya menggunakan satu file saja

  - saya juga biasanya membuat game menggunakan C#, tapi karena lacture notes menggunakan Java
  maka code ini juga menggunakan java

  - CODE INI SAYA GUNAKAN PADA FORUM "inheritence" DAN "encapsulation" NAMUN DENGAN PENJELASAN YANG BERBEDA
  SESUAI DENGAN JUDUL FORUM MASING-MASING
*/

// Di sini penjelasan code akan saya fokuskan kepada pembahasan ENCAPSULATION

// class ini seharusnya menggunakan public agar dapat diakses oleh semua file
// namun untuk mempersimple contoh dan java sendiri tidak bisa memiliki lebih dari satu public class
// maka tidak saya beri access modifier
class Weapon {

  // variable yang akan dimilki weapon
  // menggunakan protected karena variable ini hanya boleh diakses class ini
  // dan subclass yang inherit dari class ini
  protected String name;
  protected int damage;

  // fungsi constructor pasti dibuat public agar fungsi ini dapat diakses dimanapun
  public Weapon(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  // fungsi ketika weapon di set atau equip oleh player
  // fungsi ini juga dibuat public agar bisa diakses dimanapun,
  // kalau dibuat protected, variable lain tidak bisa mengakses fungsi ini
  public void use() {
    // biasanya muncul semacam popup info ketika weapon di equip,
    // tapi di sini saya hanya menggunakan print untuk simulasi
    System.out.println("Using weapon :  " + name);
  }

  // fungsi untuk mendapatkan value damage (biasanya ketika akan menyerang atau
  // membandingkan damage weapon lama dan weapon baru yang didapat)
  // fungsi ini juga dibuat public agar bisa diakses dimanapun,
  // kalau dibuat protected, variable lain tidak bisa mengakses fungsi ini
  public int getDamage() {
    return damage;
  }

  // fungsi untuk mendapatkan value name (biasanya ketika berada dalam dialog yang
  // membutuhkan nama weapon)
  // fungsi ini juga dibuat public agar bisa diakses dimanapun,
  // kalau dibuat protected, variable lain tidak bisa mengakses fungsi ini
  public String getName() {
    return name;
  }
}

// alasan sama seperti class Weapon, untuk contoh simple dan agar bisa di dalam satu file
// saya tidak menggunakan access modifier public
class Sword extends Weapon {

  // constructor pasti menggunakan public agar dapat diakses dimanapun
  public Sword() {
    // super digunakan untuk memanggil constructor function dari parent (dari class Weapon)
    super("Sword", 25);
  }

  // fungsi yang mengoverride fungsi use pada parent class (class Weapon)
  // tujuan override di sini adalah agar popup text lebih berasa immersive
  // karena setiap jenis weapon cara penggunaannya berbeda
  // fungsi ini juga menggunakan public, tapi di sini dikarenakan fungsi dari parent sendiri (class Weapon)
  // menggunakan public, kalau diganti private, tidak bisa di override karena terhitung beda function
  @Override
  public void use() {
    System.out.println(
      "Slashing enemy with sword! Dealing " + damage + " damage"
    );
  }
}

// alasan sama seperti class Weapon, untuk contoh simple dan agar bisa di dalam satu file
// saya tidak menggunakan access modifier public
class MagicStaff extends Weapon {

  // custom variable yang hanya dimiliki class MagicStaff (saat menyerang perlu mana)
  // dibuat private karena untuk mengakses atau mengubah variable ini
  // harus melalui sebuah function pada class ini (tidak bisa langsung akses dari variable nya)
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
  // fungsi ini juga menggunakan public, tapi di sini dikarenakan fungsi dari parent sendiri (class Weapon)
  // menggunakan public, kalau diganti private, tidak bisa di override karena terhitung beda function
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
// untuk contoh simple dan agar bisa di dalam satu file
// saya tidak menggunakan access modifier public
class Player {

  // custom variable yang dimiliki oleh player
  // saya buat private agar variable-variable ini hanya bisa diakses pada class ini saja
  // dan juga class ini tidak akan ada class turunan, jadi private lebih cocok
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
  // dibuat public agar function ini dapat diakses dimanapun
  public void equipWeapon(Weapon weapon) {
    // set weapon ke variable weapon pada class ini
    this.weapon = weapon;

    // biasanya muncul popup animation saat equip weapon
    // tapi di sini saya hanya menggunakan println untuk simulasi
    System.out.println(name + " eqipping " + weapon.getName());
  }

  // fungsi player saat menyerang
  // dibuat public agar function ini dapat diakses dimanapun
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
// maka dari itu menggunakan access modifier public
public class Main {

  // merupakan FUNGSI utama yang akan dieksekusi ketika file ini di run
  // maka dari itu menggunakan access modifier public
  public static void main(String[] args) {
    // untuk inisialisasi variable yang menggunakan data type dari class Player
    // karena contructor pada Player menggunakan public,
    // maka variable ini dapat memanggil contructor tersebut untuk inisialisasi variable
    Player player = new Player("Player Name");

    // untuk inisialisasi variable yang menggunakan data type dari class Sword dan MagicStaff
    // karena contructor pada Sword dan MagicStaff menggunakan public,
    // maka kedua variable ini dapat memanggil contructor tersebut untuk inisialisasi variable
    Weapon sword = new Sword();
    Weapon staff = new MagicStaff();

    // untuk simulasi player meng-equip dan menggunakan weapon untuk menyerang
    // karena fungsi equipWeapon dan attack berupa public (pada class Player)
    // maka variable player ini dapat mengakses fungsi ini
    player.equipWeapon(sword);
    player.attack();

    // hanya untuk spacing di console
    System.out.println();

    // untuk simulasi player mengubah senjata menjadi magic staff dan
    // menggunakan weapon untuk menyerang
    // karena fungsi equipWeapon dan attack berupa public (pada class Player)
    // maka variable player ini dapat mengakses fungsi ini
    player.equipWeapon(staff);
    player.attack();
  }
}
