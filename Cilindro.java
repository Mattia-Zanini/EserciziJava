public class Cilindro{
        public static void main(String[] args){
                double raggio = 10.12;
                double altezza = 10.87;
                double pi = 3.14159265358979;
                double areaBase = pi*raggio*raggio;
                double volume = areaBase * altezza;
                
                System.out.println("***Il volume del cilindro di raggio " + raggio +" e altezza "+ altezza +" e' pari a "+ volume +"***");
        }
}
