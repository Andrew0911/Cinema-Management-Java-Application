package Bilete;
import Filme.*;

public abstract class Bilet implements Comparable<Bilet>
{
    protected double pret;

    protected int sala;

    protected int rand;

    protected int loc;

    protected Film film;

    public Bilet(double pret, int sala, int rand, int loc, Film film)
    {
        this.pret = pret;
        this.sala = sala;
        this.rand = rand;
        this.loc = loc;
        this.film = film;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


    abstract public double calcul_pret(double pret_film);

    @Override
    public int compareTo(Bilet bilet)
    {
        if(this.pret != bilet.pret)
        {
            if(this.pret - bilet.getPret() > 0)
                return 1;
            else
                return -1;
        }
        return this.film.getNume_film().compareTo(bilet.film.getNume_film());
    }
}
