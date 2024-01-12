// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.IOException;

public class ProfDequeTester {
   public ProfDequeTester() {
   }

   public static void main(String[] var0) throws IOException {
      boolean var1 = true;
      ArrayDeque var2 = new ArrayDeque();
      System.out.println("Ho creato una deque vuota");
      System.out.println("Provo ad accedere con getFirst");

      try {
         var2.getFirst();
      } catch (EmptyDequeException var7) {
         System.out.println("Deque 1 e' vuoto, impossibile visualizzare l'elemento");
      }

      System.out.println("Provo a accedere con getLast");

      try {
         var2.getLast();
      } catch (EmptyDequeException var6) {
         System.out.println("Deque 1 e' vuoto, impossibile visualizzare l'elemento");
      }

      System.out.println("Provo a rimuovere con removeFirst");

      try {
         var2.removeFirst();
      } catch (EmptyDequeException var5) {
         System.out.println("Deque 1 e' vuoto, impossibile estrarre");
      }

      System.out.println("Provo a rimuovere con removeLast");

      try {
         var2.removeLast();
      } catch (EmptyDequeException var4) {
         System.out.println("Deque 1 e' vuoto, impossibile estrarre");
      }

      System.out.println("Aggiungo e rimuovo un po' di elementi...");
      var2.addFirst("uno");
      var2.addFirst("due");
      var2.addLast("tre");
      var2.addLast("quattro");
      var2.addFirst("cinque");
      if (!var2.removeLast().equals("quattro")) {
         var1 = false;
      }

      if (!var2.removeLast().equals("tre")) {
         var1 = false;
      }

      if (!var2.removeFirst().equals("cinque")) {
         var1 = false;
      }

      if (!var2.removeFirst().equals("due")) {
         var1 = false;
      }

      if (!var2.removeLast().equals("uno")) {
         var1 = false;
      }

      if (var1) {
         System.out.println("tutto bene");
      } else {
         System.out.println("errore");
      }

   }
}
