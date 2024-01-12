
/**
 * Scrivere una classe DequeTester di prova che:
 * 
 * - crei tre esemplari della classe ArrayDeque di nome uno, due e tre
 * - legga dall'ingresso standard una sequenza di numeri interi (uno per riga) e
 * li inserisca alla fine della coda uno (con addLast)
 * - svuoti la coda uno dalla fine (con removeLast) trasferendone il contenuto
 * all'inizio della coda due (con AddFirst)
 * - svuoti la coda due dall'inizio (con removeFirst) inserendo i dati alla fine
 * della coda tre
 * - svuoti infine la coda tre dall'inizio scrivendo i dati sull'uscita
 * standard,
 * uno per riga.
 * I dati in uscita dovranno essere nello stesso ordine dei dati in ingresso.
 */

import java.util.Random;

public class ArrayDequeTester {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayDeque uno = new ArrayDeque();
        ArrayDeque due = new ArrayDeque();
        ArrayDeque tre = new ArrayDeque();

        for (int i = 0; i < 10; i++) {
            int n = rnd.nextInt(100);
            uno.addLast(n);
        }
        uno.printDeque();
        while (!uno.isEmpty()) {
            due.addFirst(uno.removeLast());
        }
        while (!due.isEmpty()) {
            tre.addLast(due.removeFirst());
        }

        while (!tre.isEmpty()) {
            System.out.println(tre.removeFirst());
        }
    }
}