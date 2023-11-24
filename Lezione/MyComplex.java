public class MyComplex {
    private double re; // parte reale
    private double im; // parte immaginaria

    public MyComplex(double real, double immag) {
        re = real;
        im = immag;
    }

    public MyComplex(double real) {
        re = real;
        im = 0;
    }

    public MyComplex() {
        re = 0;
        im = 0;
    }

    // Restituisce un oggetto myComplex in cui la parte reale e quella immaginaria
    // sono la somma della parte reale (rispettivamente immaginaria) dell’oggetto
    // invocante e del parametro esplicito
    public MyComplex add(MyComplex addendo) {
        return new MyComplex(re + addendo.re, im + addendo.im);
    }

    // Restituisce un oggetto myComplex somma dei due
    public static MyComplex add(MyComplex addendo1, MyComplex addendo2) {
        return new MyComplex(addendo1.re + addendo2.re, addendo1.im + addendo2.im);
    }

    // Restituisce un oggetto myComplex in cui la parte reale e quella immaginaria
    // sono la differenza della parte reale (rispettivamente immaginaria)
    // dell’oggetto invocante e del parametro esplicito
    public MyComplex sub(MyComplex sottraendo) {
        return new MyComplex(re - sottraendo.re, im - sottraendo.im);
    }

    // Restituisce un oggetto myComplex differenza dei due
    public static MyComplex sub(MyComplex minuendo, MyComplex sottraendo) {
        return new MyComplex(minuendo.re - sottraendo.re, minuendo.im - sottraendo.im);
    }

    // Restituisce un oggetto myComplex prodotto del parametro implicito e del
    // parametro esplicito
    public MyComplex mult(MyComplex moltiplicatore) {
        return new MyComplex(re * moltiplicatore.re - im * moltiplicatore.im,
                re * moltiplicatore.im + im * moltiplicatore.re);
    }

    // Restituisce un oggetto myComplex quoziente del parametro implicito e del
    // parametro esplicito
    public MyComplex div(MyComplex divisore) {
        return mult(divisore.rev());
    }

    // Restituisce un oggetto myComplex inverso del parametro implicito
    public MyComplex rev() {
        return new MyComplex((re / mod() * mod()), -im / (mod() * mod()));
    }

    // Restituisce un oggetto myComplex coniugato del parametro implicito
    public MyComplex conj() {
        return new MyComplex(re, -im);
    }

    // Restituisce un double pari al modulo del parametro implicito
    public double mod() {
        return Math.sqrt(re * re + im * im);
    }

    // Restituisce la parte reale del parametro implicito
    public double re() {
        return re;
    }

    // Restituisce la parte immaginaria del parametro implicito
    public double im() {
        return im;
    }

    // Restituisce un oggetto stringa rappresentazione matematica del numero
    // immaginario
    // Es: 3+i6 oppure 5-i9
    public String toString() {
        final String UNITA_IMMAGINARIA = "i";
        if (approxEquals(im, 0))
            return String.valueOf(re);
        String sign = "-";
        if (im > 0)
            sign = "+";
        if (approxEquals(re, 0))
            return sign + UNITA_IMMAGINARIA + Math.abs(im);

        return re + " " + sign + UNITA_IMMAGINARIA + Math.abs(im);
    }

    // Confronta, con tolleranza, il parametro implicito e quello esplicito
    // La tolleranza deve essere verificata sia dalle parti reali che dalle parti
    // immaginarie
    // Suggerimento: implementare ed utilizzare un metodo ausiliario per il
    // confronto tra due double
    public boolean approxEquals(MyComplex z) {
        return approxEquals(re, z.re) && approxEquals(im, z.im);
    }

    private static boolean approxEquals(double x, double y) {
        final double EPSILON = 1E-14;
        return Math.abs(x - y) <= EPSILON * Math.max(Math.abs(x), Math.abs(y));
    }
}