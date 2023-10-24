public class Swap{
        public static void main(String[] args){
                int x = 10;
                int y = 3;
                
                x = x + y;//  --> x = 13
                y = x - y;//  --> y = 10
                x = x - y;//  --> x = 3
                
                System.out.println("Valore di x: " + x);
                System.out.println("Valore di y: " + y);
        }
}
