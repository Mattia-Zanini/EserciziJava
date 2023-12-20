import java.util.Scanner;

public class TestSquare {
	private static Scanner console;

	public static void main(String[] args) {
		// non è proprio come la consegna chiedeva ma non avevo sbatti di fare lo split
		// della stringa e di fare il check per ogni valore
		int x1 = checkInput("Inserisci la posizione x del centro del quadrato 1");
		int y1 = checkInput("Inserisci la posizione y del centro del quadrato 1");
		int lato1 = checkInput("Inserisci la dimensione del lato del quadrato 1");
		Square s1 = new Square(x1, y1, lato1);

		int x2 = checkInput("Inserisci la posizione x del centro del quadrato 2");
		int y2 = checkInput("Inserisci la posizione y del centro del quadrato 2");
		int lato2 = checkInput("Inserisci la dimensione del lato del quadrato 2");
		Square s2 = new Square(x2, y2, lato2);

		if (s1.compareTo(s2) < 0) {
			System.out.println("Area quadrato 2: " + s2.getArea());
			System.out.println("Area quadrato 1: " + s1.getArea());
		} else {
			System.out.println("Area quadrato 1: " + s1.getArea());
			System.out.println("Area quadrato 2: " + s2.getArea());
		}

		int width1 = checkInput("Inserisci la nuova larghezza del quadrato 1");
		int height1 = checkInput("Inserisci la nuova altezza del quadrato 1");
		s1.setSize(width1, height1);

		int width2 = checkInput("Inserisci la nuova larghezza del quadrato 2");
		int height2 = checkInput("Inserisci la nuova altezza del quadrato 2");
		s1.setSize(width2, height2);

		if (s1.compareTo(s2) < 0) {
			System.out.println("Area quadrato 2: " + s2.getArea());
			System.out.println("Area quadrato 1: " + s1.getArea());
		} else {
			System.out.println("Area quadrato 1: " + s1.getArea());
			System.out.println("Area quadrato 2: " + s2.getArea());
		}

		console.close();
	}

	private static int checkInput(String message) {
		console = new Scanner(System.in);
		int num = 0;
		boolean isCorrect = false;
		System.out.println(message);
		do {
			try {
				num = Integer.parseInt(console.next());
				isCorrect = true;
			} catch (NumberFormatException e) {
				isCorrect = false;
				System.out.println("Input non corretto, deve essere di tipo [int]");
			}
		} while (!isCorrect);
		// non posso chiudere lo scanner pechè non viene più riaperto sennò
		// console.close();
		return num;
	}
}
