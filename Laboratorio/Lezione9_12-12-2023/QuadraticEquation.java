public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    /*
     * Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
     * e inizializza i campi di esemplare secondo i valori ricevuti
     */
    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff) {
        a = acoeff;
        b = bcoeff;
        c = ccoeff;
    }

    /*
     * Restituisce la prima delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     * 
     * x1 = (-b + sqrt(Δ) ) / 2*a
     */
    public double getSolution1() {
        if (a != 0) {
            double numeratore = (-1) * b + Math.sqrt(getDiscriminante(a, b, c));
            double denominatore = 2 * a;
            return numeratore / denominatore;
        } else if (a == 0 && b != 0) {
            double y = (-1) * c / b;
            return y;
        }
        return 0;
    }

    /*
     * Restituisce la seconda delle due soluzioni dell'equazione quadratica,
     * usando la ben nota formula...
     * 
     * x2 = (-b - sqrt(Δ) ) / 2*a
     */
    public double getSolution2() {
        if (a != 0) {
            double numeratore = (-1) * b - Math.sqrt(getDiscriminante(a, b, c));
            double denominatore = 2 * a;
            return numeratore / denominatore;
        } else if (a == 0 && b != 0) {
            double y = (-1) * c / b;
            return y;
        }
        return 0;
    }

    /*
     * Restituisce il valore false se l'equazione non ha soluzioni
     * (ovvero se il discriminante e` negativo)
     * 
     * a=b=0 e c!=0 (l'equazione non ha soluzioni)
     * a=0, b!=0 (l'equazione ha una soluzione)
     * a=b=c=0 (l'equazione ha infinite soluzioni)
     */
    public boolean hasSolutions() {
        if (a == 0 && b == 0 && c != 0)
            return false;
        if (getDiscriminante(a, b, c) < 0)
            return false;
        return true;
    }

    /*
     * Restituisce il valore del discriminante dell'equazione
     * Δ = b^2 - 4 * a * c
     */
    public static double getDiscriminante(double a, double b, double c) {
        return (b * b) + (-1) * 4 * a * c;
    }
}