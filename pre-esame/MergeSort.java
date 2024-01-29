import java.util.Random;
public class MergeSort{
	public static void main(String[] args){
		Random rnd = new Random();
		final int SIZE = 100;
		final int BOUND = 500;
		int[] v = new int[SIZE];
		
		// inizializzo l'array
		for(int i = 0; i < v.length; i++)
			v[i] = rnd.nextInt(BOUND);
		
		mergeSort(v);
		printArray(v);
	}
	private static void mergeSort(int[] a){
		if(a == null) return;
		if(a.length < 2) return;
		
		int mid = a.length / 2;
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];
		arraycopy(a, 0, left, 0, mid);
		arraycopy(a, mid, right, 0, right.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(a, left, right);
	}
	private static void merge(int[] a, int[] b, int[] c){
		int ia = 0, ib = 0, ic = 0;
		// primo step
		while(ib < b.length && ic < c.length){
			if(b[ib] < c[ic])
				a[ia++] = b[ib++];
			else
				a[ia++] = c[ic++];
		}
		// secondo step
		while(ib < b.length)
			a[ia++] = b[ib++];
		while(ic < c.length)
			a[ia++] = c[ic++];
	}
	
	
	private static void arraycopy(int[] src, int startSrc, int[] dest, int destStart, int size){
		for(int i = 0; i < size; i++)
			dest[destStart + i] = src[startSrc + i];
		return;
	}
	private static void printArray(int[] v){
		for(int i = 0; i < v.length; i++)
			System.out.printf("[%d] : %d\n", i, v[i]);
	}
}
