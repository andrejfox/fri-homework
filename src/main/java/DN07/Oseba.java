package DN07;

public class Oseba {

    private final String ip;
    public final char spol;
    private final int starost;

    public Oseba(String ip, char spol, int starost) {
        this.ip = ip;
        this.spol = spol;
        this.starost = starost;
    }

    public String toString() {
        return String.format("%s, %c, %d", ip, spol, starost);
    }

    public boolean jeStarejsaOd(Oseba os) {
        return this.starost > os.starost;
    }
}
