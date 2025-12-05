package DN06;

public class Tocka {

    private double x;
    private double y;

    public Tocka(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double vrniX(){
        return x;
    }

    public double vrniY() {
        return y;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", x, y)
                .replace(',','.')
                .replace(". ", ", ");
    }

    public double razdalja(Tocka t) {
        return Math.hypot(t.x - x, t.y - y);
    }

    public static Tocka izhodisce() {
        return new Tocka(0,0);
    }

    public double razdaljaOdIzhodisca() {
        return razdalja(izhodisce());
    }
}
