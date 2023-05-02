package Persoane;

import Persoane.*;
public interface Validari {

    /// Validari Persoane
    static boolean validare_telefon(String telefon)
    {
        return telefon.matches("(07)[0-9]{8}");
    }

    static boolean validare_gen(String gen)
    {
        return gen.matches("M|F");
    }

    static boolean validare_email(String email)
    {
        return email.matches("(.*)@gmail.com|(.*)@yahoo.com|(.*)@s.unibuc.ro|(.*)@yahoo.ro|(.*)@unibuc.ro|(.*)@outlook.com");
    }

    static boolean validare_varsta(int varsta)
    {
        return varsta > 0;
    }

    static boolean validare_categorie(String categorie)
    {
        return categorie.matches("Student|Elev|Adult|Pensionar");
    }

    static boolean validare_clasa(int clasa)
    {
        return clasa >= 1 && clasa <= 12;
    }

}
