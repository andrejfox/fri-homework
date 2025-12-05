package DN06;

public class Premica {

    private double k;
    private double n;

    public Premica(double k, double n) {
        this.k = k;
        this.n = n;
    }

    public double vrniK() {
        return k;
    }

    public double vrniN() {
        return n;
    }

    public String toString() {
        return String.format("y = %.2f x + %.2f", k, n)
                .replace(',', '.');
    }

    public Tocka tockaPriX(double x) {
        return new Tocka(x, k * x + n);
    }

    public static Premica skoziTocko(double k, Tocka t) {
        return new Premica(k, t.vrniY() - k * t.vrniX());
    }

    public Premica vzporednica(Tocka t) {
        return new Premica(k, t.vrniY() - k * t.vrniX());
    }

    public Premica pravokotnica(Tocka t) {
        double k = -(1 / this.k);
        double n = t.vrniY() - k * t.vrniX();
        return new Premica(k, n);
    }

    public Tocka presecisce(Premica p, double epsilon) {
        if (Math.abs(this.k - p.k) < epsilon) return null;
        double x = (p.n - this.n) / (this.k - p.k);
        return p.tockaPriX(x);
    }

    public Tocka projekcija(Tocka t) {
        Premica p = Premica.skoziTocko(-1 / this.k, t);
        return presecisce(p, 0);
    }

    public double razdalja(Tocka t) {
        Tocka t2 = projekcija(t);
        return Math.hypot(t.vrniX() - t2.vrniX(), t.vrniY() - t2.vrniY());
    }

    public double razdaljaOdIzhodisca() {
        return razdalja(Tocka.izhodisce());
    }

    public double razdalja(double n) {
        Premica p = new Premica(k, n);
        Tocka t1 = p.tockaPriX(0);
        Tocka t2 = this.projekcija(t1);

        return t1.razdalja(t2);
    }
}
