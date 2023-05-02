package Filme;

public class Film implements Comparable<Film>
{
    private String nume_film;

    private int durata;

    private int zi, luna, an;

    private int ora, min;

    private String tip;

    private double pret_film;

    public Film(String nume_film, int durata, int zi, int luna, int an, int ora, int min, String tip, double pret_film)
    {
        this.nume_film = nume_film;
        this.durata = durata;
        this.zi = zi;
        this.luna = luna;
        this.an = an;
        this.ora = ora;
        this.min = min;
        this.tip = tip;
        this.pret_film = pret_film;
    }

    public String getNume_film() {
        return nume_film;
    }

    public void setNume_film(String nume_film) {
        this.nume_film = nume_film;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public int getLuna() {
        return luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getPret_film() {
        return pret_film;
    }

    public void setPret_film(double pret_film) {
        this.pret_film = pret_film;
    }

    @Override
    public int compareTo(Film film)
    {
        return this.getNume_film().compareTo(film.getNume_film());
    }
}
