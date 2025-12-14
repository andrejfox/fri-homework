package DN07;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stanovanje {

    private final Oseba[] stanovalci;

    public Stanovanje levi = null;
    public Stanovanje zgornji = null;
    public Stanovanje desni = null;
    public Stanovanje spodnji = null;


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
        Oseba[] arr = new Oseba[]{
                this.starosta(),
                levi.starosta(),
                zgornji.starosta(),
                desni.starosta(),
                spodnji.starosta()
        };

        Arrays.sort(arr);

        return arr[4];
    }

    public Oseba[] stanocalciSosedov(Stanovanje notHere) {

        Oseba[] leviSosedi =
                (levi == null || levi == notHere) ? new Oseba[0] : levi.stanovalci;

        Oseba[] zgornjiSosedi =
                (zgornji == null || zgornji == notHere) ? new Oseba[0] : zgornji.stanovalci;

        Oseba[] desniSosedi =
                (desni == null || desni == notHere) ? new Oseba[0] : desni.stanovalci;

        Oseba[] spodnjiSosedi =
                (spodnji == null || spodnji == notHere) ? new Oseba[0] : spodnji.stanovalci;

        Oseba[] ret = new Oseba[
                leviSosedi.length +
                        zgornjiSosedi.length +
                        desniSosedi.length +
                        spodnjiSosedi.length
                ];

        int pos = 0;

        System.arraycopy(leviSosedi, 0, ret, pos, leviSosedi.length);
        pos += leviSosedi.length;

        System.arraycopy(zgornjiSosedi, 0, ret, pos, zgornjiSosedi.length);
        pos += zgornjiSosedi.length;

        System.arraycopy(desniSosedi, 0, ret, pos, desniSosedi.length);
        pos += desniSosedi.length;

        System.arraycopy(spodnjiSosedi, 0, ret, pos, spodnjiSosedi.length);

        return ret;
    }


    public Oseba[] sosedjeSosedov() {

        Oseba[] levi2    = (levi == null)    ? new Oseba[0] : levi.stanocalciSosedov(this);
        Oseba[] zgornji2 = (zgornji == null) ? new Oseba[0] : zgornji.stanocalciSosedov(this);
        Oseba[] desni2   = (desni == null)   ? new Oseba[0] : desni.stanocalciSosedov(this);
        Oseba[] spodnji2 = (spodnji == null) ? new Oseba[0] : spodnji.stanocalciSosedov(this);

        Oseba[] ret = new Oseba[
                levi2.length +
                        zgornji2.length +
                        desni2.length +
                        spodnji2.length
                ];

        int pos = 0;

        System.arraycopy(levi2, 0, ret, pos, levi2.length);
        pos += levi2.length;

        System.arraycopy(zgornji2, 0, ret, pos, zgornji2.length);
        pos += zgornji2.length;

        System.arraycopy(desni2, 0, ret, pos, desni2.length);
        pos += desni2.length;

        System.arraycopy(spodnji2, 0, ret, pos, spodnji2.length);

        return ret;
    }
}
