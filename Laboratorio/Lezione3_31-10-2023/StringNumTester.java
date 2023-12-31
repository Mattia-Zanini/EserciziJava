/*
  Esempi di manipolazioni di stringhe e conversioni tra stringhe e numeri
*/

public class StringNumTester {

  public static void main(String[] args) {

    String teststring = "stringa di test";

    // ******** lunghezza di una stringa **************
    int teststringlength = teststring.length();
    System.out.println("lunghezza della stringa: " + teststringlength);

    // ******* estrazione di una sottostringa ************

    int first = 3; // provare varie combinazioni di first e last, in
    int last = 10; // particolare esaminare i seguenti casi:
                   // first<0, last>15, first=last, first>last
                   // Cosa succede? Perche`? Consultare la documentazione

    String testsubstring1 = teststring.substring(first, last);
    String testsubstring2 = teststring.substring(first);
    System.out.println("sottostringa1: " + testsubstring1);
    System.out.println("sottostringa2: " + testsubstring2);

    // String testsubstring3 = teststring.substring(-1);
    // System.out.println("sottostringa3: " + testsubstring3);

    // String testsubstring4 = teststring.substring(first, 16);
    // System.out.println("sottostringa4: " + testsubstring4);

    String testsubstring5 = teststring.substring(first, first);
    System.out.println("sottostringa5: " + testsubstring5);

    // String testsubstring6 = teststring.substring(last, first);
    // System.out.println("sottostringa6: " + testsubstring6);

    // *********** la stringa vuota ****************
    String stringavuota = "";
    String stringaspazio = " ";

    System.out.println("Lunghezza stringavuota: " + stringavuota.length());
    System.out.println("Lunghezza stringaspazio: " + stringaspazio.length());

    // ************* convertire stringhe in numeri ************

    String stringanumerica = "Stringa 122 di test 1.34";

    first = 8; // provare a cambiare i valori di first e last. Si generano
    last = 11; // errori? Di che tipo? Perche`?
    String stringaint = stringanumerica.substring(first, last);
    int intdastringa = Integer.parseInt(stringaint);
    System.out.println("Intero da stringa: " + intdastringa);

    // stringaint = stringanumerica.substring(6, 13);
    // intdastringa = Integer.parseInt(stringaint);
    // System.out.println("TEST Intero da stringa: " + intdastringa);

    first = 20; // provare a cambiare i valori di first e last. Si generano
    last = 24; // errori? Di che tipo? Perche`?
    String stringadouble = stringanumerica.substring(first, last);
    double doubledastringa = Double.parseDouble(stringadouble);
    System.out.println("Double da stringa: " + doubledastringa);

    // stringadouble = stringanumerica.substring(18, 23);
    // doubledastringa = Double.parseDouble(stringadouble);
    // System.out.println("TEST Double da stringa: " + doubledastringa);

    // ************* convertire numeri in stringhe ***************

    int unintero = 122;
    double undouble = 1.34;

    String stringadaint = Integer.toString(unintero);
    System.out.print("Stringadaint: ");
    System.out.println(stringadaint);

    String stringadadouble = Double.toString(undouble);
    System.out.print("Stringadadouble: ");
    System.out.println(stringadadouble);

    // Le variabili sommastringhe e sommanumeri contengono cose diverse.
    // Perche`? Cosa significa l'operatore "+" nei due casi?
    String sommastringhe = stringadaint + stringadadouble;
    double sommanumeri = unintero + undouble;
    System.out.print("Sommastringhe: ");
    System.out.println(sommastringhe);
    System.out.print("Sommanumeri: ");
    System.out.println(sommanumeri);
  }
}