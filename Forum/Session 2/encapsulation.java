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
class Character {

  // variable yang akan dimilki character
  // menggunakan protected karena variable ini hanya boleh diakses class ini
  // dan subclass yang inherit dari class ini
  protected String name;
  protected int hp;
  protected int atk;

  // fungsi constructor pasti dibuat public agar fungsi ini dapat diakses dimanapun
  public Character(String name, int hp, int atk) {
    this.name = name;
    this.hp = hp;
    this.atk = atk;
  }

  // fungsi untuk menyerang
  // fungsi ini juga dibuat public agar bisa diakses dimanapun,
  // kalau dibuat protected, variable lain atau entity character biasa
  // tidak bisa mengakses fungsi ini
  public void attack(Character enemy) {
    // buat logic untuk melakukan attack, biasanya terdapat logic animasi, dll tapi di sini saya buat sederhana saja menggunakan print
    System.out.println(name + " deals " + atk + " damage to " + enemy.name);

    // setelah melakukan serangan, kurangi hp enemy
    enemy.hp -= atk;
  }

  // fungsi untuk mendisplay status character
  // sama seperti fungsi attack, dibuat public agar dapat diakses dimanapun
  // dan juga character biasa juga bisa mengakses fungsi ini
  public void displayStatus() {
    // buat logic untuk menampilkan status, biasanya hal ini muncul berupa popup diatas enemy atau ketima player ingin mengetahui detail suatu karakter
    // agar sederhana, saya hanya menggunakan print saja
    System.out.println();
    System.out.println("===== Status =====");
    System.out.println("Name		: " + name);
    System.out.println("Health	: " + hp);
    System.out.println("Attack	: " + atk);
    System.out.println();
  }
}

// alasan sama seperti class Character, untuk contoh simple dan agar bisa di dalam satu file
// saya tidak menggunakan access modifier public
class Warrior extends Character {

  // variable yang khusus dimiliki oleh warrior
  // dibuat private karena untuk mengakses atau mengubah variable ini
  // harus melalui sebuah function pada class ini (tidak bisa langsung akses dari variable nya)
  private int defense;

  // constructor pasti menggunakan public agar dapat diakses dimanapun
  public Warrior(String name) {
    // super digunakan untuk memanggil constructor function dari parent (dari class Character)
    super(name, 150, 20);
    // untuk set defense
    this.defense = 10;
  }

  // fungsi warrior untuk melakukan defend
  // dibuat public agar function ini dapat diakses dimanapun
  public void defend() {
    // biasanya untuk logika animasi dari defend, tapi disini saya gunakan print saja
    System.out.println(name + " using shield! Defense +" + defense);
  }
}

// alasan sama seperti class Character, untuk contoh simple dan agar bisa di dalam satu file
// saya tidak menggunakan access modifier public
class Mage extends Character {

  // variable yang khusus dimiliki oleh mage
  // dibuat private karena untuk mengakses atau mengubah variable ini
  // harus melalui sebuah function pada class ini (tidak bisa langsung akses dari variable nya)
  private int mana;

  // constructor dari class mage
  public Mage(String name) {
    // untuk memanggil constructor dari parent class (dari class Character)
    super(name, 100, 30);
    // untuk set mana
    this.mana = 100;
  }

  // fungsi khusus untuk mage dimana dia bisa cast a spell
  // dibuat public agar function ini dapat diakses dimanapun
  public void castSpell(Character enemy) {
    // logika untuk cek apakah mana cukup untuk cast spell
    if (mana >= 20) {
      // jika mana cukup, cast a spell, biasanya terdapat logika untuk animasi, di sini saya menggunakan print saja untuk simulasi
      System.out.println(name + " melempar fireball ke " + enemy.name);

      // kurangi enemy hp
      enemy.hp -= 40;

      // kurangi mana
      mana -= 20;
    } else {
      // jika mana kurang, biasanya terdapat animasi yang menunjukkan jika mana kurang
      // atau bisa juga dengan tombol spell tidak bisa di klik, di sini saya menggunakan print untuk simulasi saja
      System.out.println(name + " tidak punya cukup mana!");
    }
  }
}

// merupakan CLASS utama yang akan dieksekusi ketika file ini di run
// maka dari itu menggunakan access modifier public
public class Main {

  // merupakan FUNGSI utama yang akan dieksekusi ketika file ini di run
  // maka dari itu menggunakan access modifier public
  public static void main(String[] args) {
    // untuk inisialisasi variable yang menggunakan data type dari class Warrior dan Mage
    // karena contructor pada Warrior dan Mage menggunakan public,
    // maka kedua variable ini dapat memanggil contructor tersebut untuk inisialisasi variable
    Warrior warrior = new Warrior("Warrior 1");
    Mage mage = new Mage("Mage 1");

    // untuk simulasi ketika player ingin melihat status warrior dan mage
    // karena displayStatus berupa public (pada parent class Character)
    // maka kedua variable ini dapat mengakses fungsi ini
    warrior.displayStatus();
    mage.displayStatus();

    // panggil fungsi attack pada warrior dengan mage sebagai parameter enemy
    // untuk mensimulasikan warrior menyerang mage
    // karena fungsi attack berupa public (pada parent class Character)
    // maka variable warrior ini dapat mengakses fungsi ini
    warrior.attack(mage);

    // panggil fungsi castSpell pada mage dengan warrior sebagai parameter enemy
    // untuk mensimulasikan mage menggunakan spell untuk menyerang warrior
    // karena fungsi castSpell berupa public (pada class Mage)
    // maka variable mage ini dapat mengakses fungsi ini
    mage.castSpell(warrior);

    // untuk simulasi game mendisplay status warrior dan mage setelah mereka melakukan attack masing-masing
    // karena displayStatus berupa public (pada parent class Character)
    // maka kedua variable ini dapat mengakses fungsi ini
    warrior.displayStatus();
    mage.displayStatus();
  }
}
