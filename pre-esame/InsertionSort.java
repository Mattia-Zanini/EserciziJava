import java.util.Random;
public class InsertionSort{
	public static void main(String[] args){
		Random rnd = new Random();
		final int SIZE = 200;
		final int BOUND = 500;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			array[i] = rnd.nextInt(BOUND);
		insertionSort(array);
		printArray(array);
	}
	private static void insertionSort(int[] a){
		// comincio da 1 perche' e' l'unico elemento da non considerare alll'inizio
		for(int i = 1; i < a.length; i++){
			// sposto a[i] verso sinistra finché serve: 
			// - il primo elemento con cui confrontarlo è a[i-1], quindi parto con j = i-1
			for(int j = i - 1; j >= 0; j--){
				if(a[j] > a[j+1])
					swap(a, j, j+1); // devo spostare a[j+1] verso sinistra
				else // non devo piu' spostare
					break;
			}
		}
	}
	private static void swap(int[] v, int a, int b){
		int tmp = v[b];
		v[b] = v[a];
		v[a] = tmp;
	}
	private static void printArray(int[] v){
		for(int i = 0; i < v.length; i++)
			System.out.printf("[%d] : %d\n", i, v[i]);
	}
}
