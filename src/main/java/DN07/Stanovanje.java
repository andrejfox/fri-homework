package DN07;

public class Stanovanje {

    private final Oseba[] stanovalci;

    private Stanovanje levi = null;
    private Stanovanje zgornji = null;
    private Stanovanje desni = null;
    private Stanovanje spodnji = null;


    public Stanovanje(Oseba[] stanovalci) {
        this.stanovalci = stanovalci;
    }

    public int steviloStanovalcev() {
        return stanovalci.length;
    }

    public int steviloStarejsihOd(Oseba os) {
        int count = 0;

        for (Oseba cur_os : stanovalci) {
            if (cur_os.jeStarejsaOd(os)) {
                count++;
            }
        }

        return count;
    }

    public int[] mz() {
        int mCount = 0;

        for (Oseba os : stanovalci) {
            if (os.spol == 'M') {
                mCount++;
            }
        }

        return new int[]{mCount, steviloStanovalcev() - mCount};
    }

    public Oseba starosta() {
        if (steviloStanovalcev() == 0) {
            return null;
        }

        Oseba oldest = stanovalci[0];
        for (int i = 1; i < steviloStanovalcev(); i++) {
            if (stanovalci[i].jeStarejsaOd(oldest)) {
                oldest = stanovalci[i];
            }
        }

        return oldest;
    }

    public void nastaviSosede(Stanovanje levi, Stanovanje zgornji, Stanovanje desni, Stanovanje spodnji) {
        this.levi = levi.equals(this) ? null : levi;
        this.zgornji = zgornji.equals(this) ? null : zgornji;
        this.desni = desni.equals(this) ? null : desni;
        this.spodnji = spodnji.equals(this) ? null : spodnji;
    }

    public Oseba starostaSosescine() {
        // dopolnite/popravite ...
        return null;
    }

    public Oseba[] sosedjeSosedov() {
        // dopolnite/popravite ...
        return null;
    }
}
