// nome e cognome del candidato, matricola, data, numero della postazione
// Mattia Zanini 2101840

import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class StudentSetTester{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Manca un argomento");
			return;
		}
		
		StudentSet matricole = new StudentSet();
		// ottengo le righe presenti nel file
		String[] lines = readFile(args[0]).split(";");
		// formatto ogni riga in modo tale da ottenere uno Studente e li aggiungo al Set
		for(int i = 0; i < lines.length; i++)
			matricole.add(formatStudent(lines[i]));
		System.out.println(matricole.toString());
		
		Scanner console = new Scanner(System.in);
		while(true){
			System.out.println("Inserisci una coppia di lettere da cui ottenere un insieme di matricole [q = quit]");
			String input = "";
			if(console.hasNextLine())
				input = console.nextLine();
			if(input.toUpperCase().equals(new String("q"))){
				input = "";
				console.close();
				break;
			}
			
			String[] answers = input.split(" ");
			String low = answers[0].toUpperCase();
			String high = answers[1].toUpperCase();
			
			System.out.println("--------------------------------");
			System.out.println("Ottengo il sottoinsieme [" + low + ", " + high + ")");
			// SortedSet ss = matricole.subSet("H", "V");
			SortedSet ss = matricole.subSet(low, high);
			printArray(ss.toArray());
		}
    }
    private static Student formatStudent(String text){
    	int matricola = 0;
		String space = " ";
    	String nome = "", cognome = "";
		for(int i = 0; i < 16; i++){
			if(!space.equals(text.charAt(i)))
				cognome += text.charAt(i);
		}
		for(int i = 16; i < 32; i++){
			if(!space.equals(text.charAt(i)))
				nome += text.charAt(i);
		}
		String matr = "";
		for(int i = 34; i < 40; i++){
			if(!space.equals(text.charAt(i)))
				matr += text.charAt(i);
		}
		matricola = Integer.parseInt(matr);
		return new Student(cognome, nome, matricola);
    }
    private static String readFile(String fileName){
    	String str = "";
    	try(FileReader r = new FileReader(fileName); Scanner fileInput = new Scanner(r)){
    		while(fileInput.hasNextLine())
    			str += fileInput.nextLine() + ";";
    	}
    	catch(FileNotFoundException e){
    		System.out.println("File non trovato");
    		return "";
    	}
    	catch(IOException e){
    		System.out.println(e);
    		return "";
    	}
    	return str;
    }
    private static void printArray(Object[] v){
    	for(int i = 0; i < v.length; i++)
    		System.out.println(v[i]);
    }
}


class StudentSet implements SortedSet{
	private Student[] s;
	private int count;
	private static final int INITIAL_CAPACITY = 1;
	
	public StudentSet(){
		s = new Student[INITIAL_CAPACITY];
		makeEmpty();
	}
	
	public boolean isEmpty(){ return count == 0; }
    public void makeEmpty(){ count = 0; }
    public int size(){ return count; }
    
    public void add(Comparable obj){
    	if(!(obj instanceof Student))
    		throw new IllegalArgumentException();
    	int pos = find(obj);
    	if(pos != -1){
    		Object old = s[pos];
    		s[pos] = (Student) obj;
    		return;
    	}
    	if(count == s.length)
    		s = resize(s, count * 2);
    	s[count++] = (Student) obj;
    	sort();
    	return;
    }
    public boolean contains(Comparable obj){
    	int pos = find(obj);
    	if(pos == -1)
    		return false;
    	return true;
    }
    public Comparable[] toArray(){
    	Comparable[] c = new Student[count];
    	for(int i = 0; i < count; i++)
    		c[i] = s[i];
    	return c;
    }
    /* accetta una riga di input dall’utente, introdotta da tastiera:
    * la riga di input deve essere costituita da due token stringa1 e stringa2;
    * stampa a standard output il sottoinsieme di matricole formato dagli studenti
    * il cui cognome è maggiore o uguale a stringa1 (eventualmente inclusa) e strettamente minore di stringa2;
    * stampa inoltre la dimensione di tale sottoinsieme
    */
    public SortedSet subSet(Comparable fromObj, Comparable toObj){
    	if(!(fromObj instanceof String) || !(toObj instanceof String))
    		return null;
    	SortedSet x = new StudentSet();
    	for(int i = 0; i < count; i++){
    		int compLow = s[i].getCognome().compareTo((String) fromObj);
    		int compHigh = s[i].getCognome().compareTo((String) toObj);
    		if(compLow >= 0 && compHigh < 0)
    			x.add(s[i]);
    	}
    	return x;
    }
	
    public String toString(){
    	String str = "";
    	for(int i = 0; i < count; i++)
    		str += s[i].toString() + "\n";
    	return str;
    }
    
    private int find(Comparable target){
    	if(!(target instanceof Student))
    		return -1;
    	return binarySearch(s, target, 0, count - 1);
    }
    private static int binarySearch(Comparable[] v, Comparable target, int left, int right){
    	if(left > right)
    		return -1;
    	int mid = (left + right) / 2;
    	Student middle = (Student) v[mid];
    	int comp = middle.compareTo((Student) target);
    	if(comp == 0)
    		return mid;
    	else if(comp < 0)
    		return binarySearch(v, target, mid + 1, right);
    	else
    		return binarySearch(v, target, left, mid - 1);
    }
    private void sort(){
    	insertionSort(s, count);
    }
    private static void insertionSort(Comparable[] v, int size){
    	for(int i = 0; i < size; i++){
    		for(int j = i - 1; j >= 0; j--){
    			int comp = v[j].compareTo(v[j+1]);
    			if(comp > 0)
    				swap(v, j, j+1);
    			else // non devo piu' scambiare
    				break;
    		}
    	}
    }
    private static void swap(Comparable[] v, int a, int b){
    	Comparable tmp = v[a];
    	v[a] = v[b];
    	v[b] = tmp;
    }
    private static Student[] resize(Student[] v, int newSize){
    	Student[] x = new Student[newSize];
    	arraycopy(v, 0, x, 0, v.length);
    	return x;
    }
    private static void arraycopy(Object[] src, int startSrc, Object[] dest, int startDest, int size){
    	for(int i = 0; i < size; i++)
    		dest[startDest + i] = src[startSrc + i];
    }
}



class Student implements Comparable   //non modificare!!
{   public Student (String c, String n, int m) 
    {   cognome = c;
        nome = n;
        matricola = m;
    }

    public String getCognome()
    {   return cognome; }

    public String getNome()
    {   return nome; }

    public int getMatricola()
    {   return matricola; }


    /*
      I dati dello studente vengono stampati nel formato
      "cognome        nome          : n.matricola"
      Per il campo cognome e per il campo nome vengono allocati maxlength=15
      caratteri
    */
    public String toString()
    {   int maxlength = 15;
        String sep1 = "";
        for (int i = 0; i < maxlength - cognome.length(); i++) sep1 += " ";
        String sep2 = "";
        for (int i = 0; i < maxlength - nome.length(); i++) sep2 += " ";
        return cognome + sep1 + nome + sep2 + ": " + matricola; 
    }

    /*
     Lo studente x e` "maggiore" dello studente y se il cognome di x segue
     quello di y secondo l'ordinamento lessicografico. Se i due cognomi sono
     uguali, allora x e` "maggiore" di y se il nome di x segue quello di y 
     secondo l'ordinamento lessicografico. Se anche i nomi sono uguali
     (due studenti omonimi) allora x e` "maggiore" di y se la sua matricola
     e` piu` grande di quella di y.
     Esempio1:
     (DeMorgan Augustus : 511123) e` maggiore di (Babbage Charles : 599987)
     Esempio2:
     (Bernoulli Nicolaus : 577789) e` maggiore di (Bernoulli Jacob : 500098)
     Esempio3:
     (Bernoulli Nicolaus : 588890) e` maggiore di (Bernoulli Nicolaus : 577789)

    */
    public int compareTo(Object other)
    {   Student aStudent = (Student) other;
        int comp = cognome.compareTo( ((Student) other).cognome);
        if (comp == 0) comp = nome.compareTo(((Student) other).nome);
        if (comp == 0) comp = matricola - ((Student) other).matricola;
        return comp;
    }

    /*
      Due studenti x e y sono "uguali" solo se hanno lo stesso cognome e lo 
      stesso nome e lo stesso numero di matricola. 
      Esempio:
     (Babbage Charles : 599987) e` uguale a (Babbage Charles : 599987)

    */
    public boolean equals(Object other)
    {   return this.compareTo(other) == 0;
    }

    private String cognome;
    private String nome;
    private int matricola;
}


interface SortedSet     //non modificare!!
{   // verifica se l'insieme contiene almeno un elemento
    boolean isEmpty(); 

    // svuota l'insieme
    void makeEmpty();
  
    // restituisce il numero di elementi nell'insieme
    int size();
  
    /*
        Inserisce l'oggetto comparabile obj nell'insieme se non e` gia` 
        presente, altrimenti fallisce silenziosamente.
    */
    void add(Comparable obj);
  
    /*
        Restituisce true se e solo se l'oggetto comparabile obj appartiene  
        all'insieme. Verranno considerate ottime le soluzioni per cui questo 
        metodo ha prestazioni O(log n) 
    */
    boolean contains(Comparable obj);
  
    /*
        Restituisce un array di oggetti comparabili contenente i riferimenti a 
        tutti gli elementi presenti nell'insieme
    */
    Comparable[] toArray();

    /*
        Riceve due riferimenti ad oggetti comparabili e restituisce un
        riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
        dell'insieme di partenza (cioe` il parametro implicito del metodo) 
        compresi tra fromObj (incluso) e toObj (escluso). 
        Se fromObj non appartiene all'insieme di partenza, il primo elemento 
        del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
        nell'insieme di partenza.
        Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
        il nuovo insieme sara` vuoto
    */
    SortedSet subSet(Comparable fromObj, Comparable toObj);
}


