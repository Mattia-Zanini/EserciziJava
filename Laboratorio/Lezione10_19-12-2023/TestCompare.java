import java.util.Random;

public class TestCompare {
	public static void main(String[] args) {
		//int[] arr = new int[] {491, 8458, 0, 544, 89798, 5458, 5648};
		Random rnd = new Random();
		BankAccount[] accounts = new BankAccount[10];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = new BankAccount(rnd.nextDouble(1000));
		
		//ArrayAlgorithms.mergeSort(arr);
		//ArrayAlgorithms.printArray(arr);
		ArrayAlgorithms.printArray(accounts);
		ArrayAlgorithms.mergeSort(accounts);
		
		System.out.println("Dopo ordinamento:");
		ArrayAlgorithms.printArray(accounts);
	}
}
