import java.util.Scanner;

public class TestSquare {
	public static void main(String[] args) {
		Square s = new Square(1,1,5);
		System.out.println("Area del quadrato: " + s.getArea());
		
		int x = checkInput("Inserisci la posizione x del centro del quadrato");
		int y = checkInput("Inserisci la posizione y del centro del quadrato");
		int lato = checkInput("Inserisci la dimensione del lato del quadrato");
	}
	private static int checkInput(String message) {
		Scanner console = new Scanner(System.in);
		int num = 0;
		boolean isCorrect = false;
		System.out.println(message);
		do {
			try {
				num = Integer.parseInt(console.next());
				isCorrect = true;
			}
			catch (NumberFormatException e) {
				isCorrect = false;
				System.out.println("Input non corretto, deve essere di tipo [int]");
			}
		}while(!isCorrect);
		return num;
	}
}
