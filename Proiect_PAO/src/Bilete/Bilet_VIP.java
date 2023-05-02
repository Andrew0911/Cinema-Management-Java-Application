package Bilete;

import Bilete.Bilet;
import Filme.Film;

public final class Bilet_VIP extends Bilet
{
    private final int procent_adaos_VIP;
    public Bilet_VIP(double pret, int sala, int rand, int loc, Film film)
    {
        super(pret, sala, rand, loc, film);
        this.procent_adaos_VIP = 50;
    }

    public int getProcent_adaos_VIP()
    {
        return procent_adaos_VIP;
    }

    @Override
    public double calcul_pret(double pret_film)
    {
        return (procent_adaos_VIP + 100) * pret_film / 100;
    }
}
