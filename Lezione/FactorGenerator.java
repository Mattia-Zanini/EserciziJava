public class FactorGenerator {
    private int numero;

    public FactorGenerator(int valore) {
        if (valore <= 1)
            throw new IllegalArgumentException();
        numero = valore;
    }

    // Il metodo nextFactor() restituisce uno dei fattori primi del numero (finché
    // ce ne sono)
    //
    // Sarà sufficiente eseguire le divisioni fra il numero e tutti i numeri interi
    // a partire da 2 fino a N, restituendo il divisore quando il resto della
    // divisione risulta 0 e aggiornando la variabile numero con il quoziente
    public int nextFactor() {
        for (int i = 2; i <= numero; i++)
            if (numero % i == 0) {
                numero /= i; // numero = numero/i;
                return i;
            }
        throw new IllegalStateException();
    }

    // Il metodo hasMoreFactors() restituisce true se e solo se esistono fattori
    // primi non ancora restituiti da nextFactor
    //
    // Sarà sufficiente controllare il valore di numero:
    // se è diverso da 1 --> ci sono ancora fattori primi
    // se è uguale a 1 --> non ci sono più fattori primi
    public boolean hasMoreFactors() {
        return (numero != 1);
    }
}