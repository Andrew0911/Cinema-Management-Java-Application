package Persoane;

import Bilete.Bilet;
import Persoane.Persoana;

public class Pensionar extends Persoana
{

    private final int discount_pensionar;

    private int an_pensionare;

    public Pensionar(String nume, int varsta, String gen, String email, String telefon, int an_pensionare)
    {
        super(nume, varsta, gen, email, telefon);
        this.an_pensionare = an_pensionare;
        this.discount_pensionar = 15;
    }

    public int getDiscount_pensionar() {
        return discount_pensionar;
    }

    public int getAn_pensionare() {
        return an_pensionare;
    }

    public void setAn_pensionare(int an_pensionare) {
        this.an_pensionare = an_pensionare;
    }

    @Override
    public void aplica_discount(int reducere_bonus)
    {
        Bilet[] tickets = this.getBilete();
        for(Bilet ticket : tickets)
        {
            ticket.setPret(ticket.getPret() * (100 - this.getDiscount_pensionar()) / 100 - reducere_bonus);
        }
    }
}
