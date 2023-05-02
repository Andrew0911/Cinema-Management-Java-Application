package Persoane;

import Persoane.Persoana;

public class Adult extends Persoana
{
    public Adult(String nume, int varsta, String gen, String email, String telefon)
    {
        super(nume, varsta, gen, email, telefon);
    }

    @Override
    public void aplica_discount(int reducere_bonus) {}
}
