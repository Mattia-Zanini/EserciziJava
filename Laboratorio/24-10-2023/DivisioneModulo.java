public class DivisioneModulo{
        public static void main(String[] args){
                int m = 10;
                int n = 3;
                int q = m / n;  //q vale 3 perche' il quoziente della divisione fra interi 10/3 e' 3
                int r = m % n; //r vale 1 perche' il resto della divisione fra interi 10/3 e' 1
                
                int CONST = 678;
                System.out.println("Cifra intera: " + CONST);
                
                System.out.println("Prima cifra: " + CONST / 100);
                CONST = CONST % 100;
                System.out.println("Seconda cifra: " + CONST / 10);
                CONST = CONST % 10;
                System.out.println("Terza cifra: " + CONST);
                
                //System.out.println("");
        }
}
