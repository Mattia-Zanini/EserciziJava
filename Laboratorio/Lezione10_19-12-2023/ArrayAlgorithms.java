public class ArrayAlgorithms {
	public static void mergeSort(int[] a) {
		if (a == null)
			return;
		if (a.length < 2)
			return;

		int mid = a.length / 2;
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);

		mergeSort(left);
		mergeSort(right);

		merge(a, left, right);
	}

	private static void merge(int[] a, int[] b, int[] c) {
		int ia = 0;
		int ib = 0;
		int ic = 0;
		while (ib < b.length && ic < c.length) {
			if (b[ib] < c[ic])
				a[ia++] = b[ib++];
			else
				a[ia++] = c[ic++];
		}
		while (ib < b.length)
			a[ia++] = b[ib++];
		while (ic < c.length)
			a[ia++] = c[ic++];
	}

	public static void mergeSort(BankAccount[] a) {
		if (a == null)
			return;
		if (a.length < 2)
			return;

		int mid = a.length / 2;
		BankAccount[] left = new BankAccount[mid];
		BankAccount[] right = new BankAccount[a.length - mid];
		System.arraycopy(a, 0, left, 0, left.length);
		System.arraycopy(a, mid, right, 0, right.length);

		mergeSort(left);
		mergeSort(right);

		merge(a, left, right);
	}

	private static void merge(BankAccount[] a, BankAccount[] b, BankAccount[] c) {
		int ia = 0;
		int ib = 0;
		int ic = 0;
		while (ib < b.length && ic < c.length) {
			if (b[ib].compareTo(c[ic]) < 0)
				a[ia++] = b[ib++];
			else
				a[ia++] = c[ic++];
		}
		while (ib < b.length)
			a[ia++] = b[ib++];
		while (ic < c.length)
			a[ia++] = c[ic++];
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.printf("[%d]: %d\n", i, a[i]);
	}

	public static void printArray(BankAccount[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.printf("[%d]: %f\n", i, a[i].getBalance());
	}
}
