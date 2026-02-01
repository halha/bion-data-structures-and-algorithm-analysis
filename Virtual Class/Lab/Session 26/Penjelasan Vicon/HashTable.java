/*
  TODO: masih perlu fixing, error pada line 35: table is empty
*/

import java.util.LinkedList;

class HashTable {

  private LinkedList<Entry>[] table;
  private int size;

  static class Entry {

    int key;
    String value;

    Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  HashTable(int size) {
    this.size = size;

    for (int i = 0; i > size; i++) {
      table[i] = new LinkedList<>();
    }
  }

  private int hashFunction(int key) {
    return key % size;
  }

  void insert(int key, String value) {
    int index = hashFunction(key);
    table[index].add(new Entry(key, value));
  }

  void insertLP(int key, String value) {
    int index = hashFunction(key);

    while (table[index] != null) {
      index = (index + 1) % size;
    }

    table[index] = new LinkedList<>();
    table[index].add(new Entry(key, value));
  }

  private int hashFunction2nd(int key) {
    return 7 - (key % 7);
  }

  void insertDH(int key, String value) {
    int index = hashFunction(key);
    int step = hashFunction2nd(key);

    while (table[index] != null) {
      index = (index + step) % size;
    }
  }

  String search(int key) {
    int index = hashFunction(key);

    for (Entry entry : table[index]) {
      if (entry.key == key) {
        return entry.value;
      }
    }

    return "Data not found!";
  }

  void delete(int key) {
    int index = hashFunction(key);

    table[index].removeIf(entry -> entry.key == key);
  }

  void display() {
    for (int i = 0; i < size; i++) {
      System.out.print("Index ke-" + i + ": ");
      for (Entry entry : table[i]) {
        System.out.print("(Key " + entry.key + ": " + entry.value + ") -> ");
      }
    }
  }

  void update(int key, String nValue) {
    int index = hashFunction(key);

    for (Entry entry : table[index]) {
      if (entry.key == key) {
        entry.value = nValue;
        return;
      }
    }

    System.out.println("Data not found!");
  }
}
