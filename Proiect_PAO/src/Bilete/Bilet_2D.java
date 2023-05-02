package Bilete;

import Bilete.Bilet;
import Filme.Film;

public final class Bilet_2D extends Bilet
{
    public Bilet_2D(double pret, int sala, int rand, int loc, Film film)
    {
        super(pret, sala, rand, loc, film);
    }
    @Override
    public double calcul_pret(double pret_film)
    {
        return pret_film;
    }
}
