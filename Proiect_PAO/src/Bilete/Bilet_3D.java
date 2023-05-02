package Bilete;

import Bilete.Bilet;
import Filme.Film;

public final class Bilet_3D extends Bilet
{
    private final int procent_adaos_3d;

    private final int pret_ochelari_3d;



    public Bilet_3D(double pret, int sala, int rand, int loc, Film film)
    {
        super(pret, sala, rand, loc, film);
        this.procent_adaos_3d = 10;
        this.pret_ochelari_3d = 5;
    }

    public int getProcent_adaos_3d() {
        return procent_adaos_3d;
    }

    public int getPret_ochelari_3d() {
        return pret_ochelari_3d;
    }

    @Override
    public double calcul_pret(double pret_film )
    {
        return (procent_adaos_3d + 100) * pret_film / 100 + pret_ochelari_3d;
    }

}
