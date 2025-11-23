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
class Character {

  // berisi variable apa saja yang dibutuhkan dari class ini
  protected String name;
  protected int hp;
  protected int atk;

  // merupakan fungsi constructor yang digunakan untuk memberi value pada variable saat class petama kali dipanggil
  public Character(String name, int hp, int atk) {
    this.name = name;
    this.hp = hp;
    this.atk = atk;
  }

  // fungsi karakter untuk menyerang suatu enemy
  public void attack(Character enemy) {
    // buat logic untuk melakukan attack, biasanya terdapat logic animasi, dll tapi di sini saya buat sederhana saja menggunakan print
    System.out.println(name + " deals " + atk + " damage to " + enemy.name);

    // setelah melakukan serangan, kurangi hp enemy
    enemy.hp -= atk;
  }

  // fungsi untuk menampilkan status karakter
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

// sekarang buat subclass yang inherit dari class Character, disini class warrior
class Warrior extends Character {

  // karena warrior bisa menggunakan perisai, maka perlu tambahan variable defense (tidak ada pada class Character)
  private int defense;

  // constructor function
  public Warrior(String name) {
    // super digunakan untuk memanggil constructor function dari parent (dari class Character)
    super(name, 150, 20);
    // untuk set defense
    this.defense = 10;
  }

  // fungsi warrior untuk melakukan defend dan juga karena tidak ada fungsi defend pada class Character
  public void defend() {
    // biasanya untuk logika animasi dari defend, tapi disini saya gunakan print saja
    System.out.println(name + " using shield! Defense +" + defense);
  }
}

// Buat subclass lagi yang inherit dari class Character
class Mage extends Character {

  // custom variable yang hanya dimiliki class Mage (mage memiliki mana stat)
  private int mana;

  // constructor dari class mage
  public Mage(String name) {
    // untuk memanggil constructor dari parent class (dari class Character)
    super(name, 100, 30);
    // untuk set mana
    this.mana = 100;
  }

  // fungsi khusus untuk mage dimana dia bisa cast a spell (di class Character tidak ada fungsi ini karena tidak semua subclass butuh)
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
public class Main {

  // merupakan FUNGSI utama yang akan dieksekusi ketika file ini di run
  public static void main(String[] args) {
    // untuk inisialisasi variable yang menggunakan data type dari class Warrior dan Mage
    Warrior warrior = new Warrior("Warrior 1");
    Mage mage = new Mage("Mage 1");

    // untuk simulasi ketika player ingin melihat status warrior dan mage
    warrior.displayStatus();
    mage.displayStatus();

    // panggil fungsi attack pada warrior dengan mage sebagai parameter enemy
    // untuk mensimulasikan warrior menyerang mage
    warrior.attack(mage);

    // panggil fungsi castSpell pada mage dengan warrior sebagai parameter enemy
    // untuk mensimulasikan mage menggunakan spell untuk menyerang warrior
    mage.castSpell(warrior);

    // untuk simulasi game mendisplay status warrior dan mage setelah mereka melakukan attack masing-masing
    warrior.displayStatus();
    mage.displayStatus();
  }
}
