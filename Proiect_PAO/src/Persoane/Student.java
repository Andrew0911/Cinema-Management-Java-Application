package Persoane;

import Bilete.Bilet;
import Persoane.Persoana;

public class Student extends Persoana
{
    private final int discount_student;
    private String facultate;

    private int an_studiu;

    public Student(String nume, int varsta, String gen, String email, String telefon, String facultate, int an_studiu)
    {
        super(nume, varsta, gen, email, telefon);
        this.facultate = facultate;
        this.an_studiu = an_studiu;
        this.discount_student = 20;
    }

    public int getDiscount_student()
    {
        return discount_student;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public int getAn_studiu() {
        return an_studiu;
    }

    public void setAn_studiu(int an_studiu) {
        this.an_studiu = an_studiu;
    }

    @Override
    public void aplica_discount(int reducere_bonus)
    {
        Bilet[] tickets = this.getBilete();
        for(Bilet ticket : tickets)
        {
            ticket.setPret(ticket.getPret() * (100 - this.getDiscount_student()) / 100 - reducere_bonus);

        }
    }
}
