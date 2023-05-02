package Persoane;

import Bilete.Bilet;
import Persoane.Persoana;

public class Elev extends Persoana
{
    private final int discount_elev;

    private int clasa;


    public Elev(String nume, int varsta, String gen, String email, String telefon, int clasa)
    {
        super(nume, varsta, gen, email, telefon);
        this.clasa = clasa;
        this.discount_elev = 30;
    }

    public int getDiscount_elev() {
        return discount_elev;
    }

    public int getClasa() {
        return clasa;
    }

    public void setClasa(int clasa) {
        this.clasa = clasa;
    }

    @Override
    public void aplica_discount(int reducere_bonus)
    {
        Bilet[] tickets = this.getBilete();
        for(Bilet ticket : tickets)
        {
            ticket.setPret(ticket.getPret() * (100 - this.getDiscount_elev()) / 100 - reducere_bonus);
        }
    }
}
