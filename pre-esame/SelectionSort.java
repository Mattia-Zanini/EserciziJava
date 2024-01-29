import java.util.Random;
public class SelectionSort{
	public static void main(String[] args){
		Random rnd = new Random();
		final int SIZE = 20;
		final int BOUND = 500;
		int[] array = new int[SIZE];
		for(int i = 0; i < SIZE; i++)
			array[i] = rnd.nextInt(BOUND);
		selectionSort(array);
		printArray(array);
	}
	private static void selectionSort(int[] v){
		if(v == null) return;
		// non considero l'ultimo elemento perchè di fatto sarà già nella posizione corretta
		for(int i = 0; i < v.length - 1; i++){
			int minPos = findMinPosFrom(v, i);
			if(minPos != i)
				swap(v, minPos, i);
		}
	}
	private static int findMinPosFrom(int[] a, int start){
		int pos = start;
		for(int i = pos + 1; i < a.length; i++){
			if(a[i] < a[pos]) //se a[i] e' piu' piccolo significa che a[pos] non e' il numero minimo
				pos = i;
		}
		return pos;
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
