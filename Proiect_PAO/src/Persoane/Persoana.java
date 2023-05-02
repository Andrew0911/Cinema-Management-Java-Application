package Persoane;
import Bilete.*;

public abstract class Persoana
{
    protected String nume;
    protected int varsta;
    protected String gen;

    protected String email;

    protected String telefon;

    protected Bilet[] bilete;


    public Persoana(String nume, int varsta, String gen, String email, String telefon)
    {
        this.nume = nume;
        this.varsta = varsta;
        this.gen = gen;
        this.email = email;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Bilet[] getBilete() {
        return bilete;
    }

    public void setBilete(Bilet[] bilete) {
        this.bilete = bilete;
    }

    abstract public void aplica_discount(int reducere_bonus);

}
