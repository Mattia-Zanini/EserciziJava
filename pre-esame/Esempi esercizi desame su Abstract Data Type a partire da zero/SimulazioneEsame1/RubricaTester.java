// nome e cognome del candidato, matricola, data, numero della postazione
// Mattia Zanini 2101840

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RubricaTester{
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("Mancano degli argomenti");
			return;
		}
		
		//Scanner console = new Scanner(System.in);
		Rubrica r1 = new Rubrica();
		Rubrica r2 = new Rubrica();
		String filename1 = args[0];
		String filename2 = args[1];
		
		// ottengo tutto il file1 togliendo inoltre tutti gli spazi
		String file = readFile(filename1).replace(" ", "");
		// separo la stringa in piu' stringhe utilizzando il carattere separatore che ho aggiunto ';'
		String[] lines = file.split(";");
		// popolo la rubrica 1
		for(int i = 0; i < lines.length; i++){
			String[] info = lines[i].split(":");
			r1.insert(info[0], new Long(info[1]));
		}
		System.out.print(r1.toString());
		System.out.println("-------------------------");
		
		// ripeto per la rubrica 2
		file = readFile(filename2).replace(" ", "");
		lines = file.split(";");
		for(int i = 0; i < lines.length; i++){
			String[] info = lines[i].split(":");
			r2.insert(info[0], new Long(info[1]));
		}
		System.out.print(r2.toString());
		System.out.println("-------------------------");
		
		Scanner console = new Scanner(System.in);
		while(true){
			System.out.println("Inserisci il nome di una persona in rubrica oppure Q/q per uscire");
			String input = console.nextLine();
			if(input.toUpperCase().equals("Q"))
				break;
			
			System.out.println("Cerco: " + input + " nella rubrica 1");
			Object x = r1.find(input);
			if(x != null){
				System.out.println("Trovato");
				// System.out.println(x);
				r1.remove(input);
				r2.insert(input, x);
			}
			else{
				System.out.println("Non trovato");
			}
		}
		
		System.out.println("-------------------------");
		System.out.print(r1.toString());
		
		System.out.println("-------------------------");
		System.out.print(r2.toString());
    }
    
    private static String readFile(String filename){
    	String str = "";
    	try(FileReader f1 = new FileReader(filename); Scanner input = new Scanner(f1)){
			while(input.hasNextLine())
				str += input.nextLine() + ";";
		}
		catch(FileNotFoundException e){
			System.out.println("File non trovato");
			System.out.println(e);
			return "";
		}
		catch(IOException e){
			System.out.println(e);
			return "";
		}
		return str;
    }
    private static void printArray(String[] str){
    	for(int i = 0; i < str.length; i++)
    		System.out.println(str[i]);
    }
}


class Rubrica implements Map
{
    private Pair[] p;
    private int vSize;
    private static final int INITIAL_CAPACITY = 1;
    
    public Rubrica(){
    	p = new Pair[INITIAL_CAPACITY];
    	makeEmpty();
    }
    
    public boolean isEmpty(){
    	return (vSize == 0);
    }
    
    public void makeEmpty(){
    	vSize = 0;
    }
    
    public int getSize(){
    	return vSize;
    }

    public String toString(){
    	String s = new String();
    	for(int i = 0; i < vSize; i++){
    		s += p[i].toString() + "\n";
    	}
    	return s;
    }
    
    public void insert(Comparable key, Object value){
    	if(value == null || !(value instanceof Long) || !(key instanceof String))
    		throw new IllegalArgumentException();
    	
    	int pos = binarySearch(key);
    	// se c'e' gia' vado a sostituire la coppia
    	if(pos != -1){
    		Object old = p[pos];
    		p[pos] = new Pair((String) key, (Long) value);
    		return;
    	}
    	// se necessario ridimensiono la rubrica
    	if(vSize == p.length)
    		p = resize(p, vSize, vSize * 2);
    	// inserisco una nuova coppia in fondo all'array
    	p[vSize++] = new Pair((String) key, (Long) value);
    	// ordino l'array
    	sort();
    	return;
    }
    public void remove(Comparable key){
    	int pos = binarySearch(key);
    	if(pos == -1)
    		return;
    	Object old = p[pos];
    	// copro il buco che si crea nell'array quando elimino il dato
    	for(int i = pos; i < vSize - 1; i++)
    		p[i] = p[i+1];
    	vSize--;
    	return;
    	
    }
    public Object find(Comparable key){
    	int pos = binarySearch(key);
    	if(pos == -1)
    		return null;
    	return p[pos].getPhone();
    }
    
    private int binarySearch(Object target){
    	return binarySearch(p, target, vSize);
    }
    
    private static int binarySearch(Object[] v, Object target, int size){
    	if(!(target instanceof String))
    		return -1;
    	return binSearch(v, target, 0, size - 1);
    }
    private static int binSearch(Object[] v, Object target, int left, int right){
    	if(left > right)
    		return -1;
    	int mid = (left + right) / 2;
    	Pair middle = (Pair) v[mid];
    	String compTarget = (String) target;
    	int compare = middle.getName().compareTo(compTarget);
    	if(compare == 0)
    		return mid;
    	else if(compare < 0)
    		// guardo a destra dell'array
    		return binSearch(v, target, mid + 1, right);
    	else
    		// guardo a sinistra dell'array
    		return binSearch(v, target, left, mid - 1);
    }
    
    private void sort(){
    	insertionSort(p, vSize);
    }
    
    private static void insertionSort(Object[] v, int size){
    	// comincio da 1 perche' e' l'unico elemento da non considerare alll'inizio
    	for(int i = 1; i < size; i++){
    		// sposto v[i] verso sinistra finché serve: 
			// - il primo elemento con cui confrontarlo è v[i-1], quindi parto con j = i-1
    		for(int j = i - 1; j >= 0; j--){
    			String j1 = ((Pair) v[j]).getName();
    			String j2 = ((Pair) v[j+1]).getName();
    			if(j1.compareTo(j2) > 0)
    				swap(v, j, j+1); // devo spostare v[j+1] aka j2 verso sinistra
    			else
    				break; // non devo piu' spostare
    		}
    	}
    }
    private static void swap(Object[] v, int a, int b){
    	Object tmp = v[a];
    	v[a] = v[b];
    	v[b] = tmp;
    }
    
    private static Pair[] resize(Pair[] v, int currentSize, int newSize){
    	Pair[] x = new Pair[newSize];
    	arraycopy(v, 0, x, 0, currentSize);
    	return x;
    }
    private static void arraycopy(Object[] src, int startSrc, Object[] dest, int startDest, int size){
    	for(int i = 0; i < size; i++)
    		dest[startDest + i] = src[startSrc + i];
    	return;
    }

    //classe privata Pair: non modificare!!
    private class Pair
    {   public Pair(String aName, long aPhone)
        {   name= aName; 
            phone = aPhone;
        }
        public String getName() 
        {   return name; }
        public long getPhone() 
        {   return phone; }
        /*
            Restituisce una stringa contenente
            - il nome, "name"
            - un carattere di separazione ( : )
            - il numero telefonico, "phone"
        */
        public String toString() 
        {   return name + " : " + phone; }
        //campi di esemplare
        private String name;
        private long phone;
    }
}


interface Map
{
    /*
        verifica se la mappa contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*Map
        svuota la mappa
    */
    void makeEmpty();

    /*
     Inserisce un elemento nella mappa. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta alla mappa; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dalla mappa l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata MapItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nella mappa l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata MapItemNotFoundException
    */
    Object find(Comparable key);
}

// Eccezione lanciata in caso di mancato ritrovamento di una coppia nella mappa
class MapItemNotFoundException extends RuntimeException {}
