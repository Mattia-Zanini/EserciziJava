import java.util.Random;

public class MyHashTableTester {
   public static void main(String[] args) {
      Random rnd = new Random();
      final int BOUND = 100;
      final int HTABLE_SIZE = 20;
      MyHashTable ht = new MyHashTable(HTABLE_SIZE);
      String[] keys = { "test", "esame", "provola", "gennaio", "informatica", "esami", "new york", "los angeles",
            "international", "esame", "provola", "tedesco", "test" };
      for (int i = 0; i < keys.length; i++)
         ht.insert(keys[i], rnd.nextInt(BOUND));
      
      System.out.println("---------------------");
      System.out.println("Stampo il contenuto senza modifiche");
      System.out.println(ht.toString());

      System.out.println("---------------------");
      System.out.println("Ora elimino una coppia con chiave: provola");
      ht.remove("provola");

      System.out.println("---------------------");
      System.out.println("Stampo il contenuto modificato");
      System.out.println(ht.toString());

      System.out.println("---------------------");
      System.out.println("Ora elimino due coppie con chiave: test");
      ht.remove("test");
      ht.remove("test");

      System.out.println("---------------------");
      System.out.println("Stampo il contenuto modificato");
      System.out.println(ht.toString());
   }
}