import Bilete.*;
import Filme.*;
import Persoane.*;

import java.util.Arrays;
import java.util.Scanner;

public class Servicii
{
    /// functie care verifica daca o data este viitoare altei date
    static boolean future_date(int zi1, int luna1, int an1, int zi2, int luna2, int an2)
    {
        if (an1 < an2)
            return false;
        else
        {
            if(an1 == an2)
            {
                if(luna1 < luna2)
                    return false;
                else
                {
                    if(luna1 == luna2)
                    {
                        return zi1 >= zi2;
                    }
                }
            }
        }
        return true;
    }

    /// afisarea optiunilor aplicatiei

    public void afisare_meniu()
    {
        System.out.println("0) EXIT");
        System.out.println("1) Afisarea filmelor disponibile");
        System.out.println("2) Adaugare film nou in lista filmelor");
        System.out.println("3) Adaugare bilete in cosul de cumparaturi");
        System.out.println("4) Aplicarea discounturilor in functie de tipul utilizatorului");
        System.out.println("5) Afisarea biletelor cumparate");
        System.out.println("6) Sortarea biletelor utilizatorului");
        System.out.println("7) Verificare promotie");
        System.out.println("8) Meniu bar");
        System.out.println("9) Stergere bilet");
        System.out.println("10) Afisare suma totala de plata");
    }

    /// 1) afisarea filmelor disponibile
    public void lista_filmelor_disponibile(Film[] filme, int day, int month, int year)
    {
        int nr = 0;
        System.out.println("Lista filmelor disponibile ");
        System.out.println();
        for (Film film : filme) {
            if (future_date(film.getZi(), film.getLuna(), film.getAn(), day, month, year)) {
                System.out.println((nr + 1) + ") " + film.getNume_film());
                nr++;
            }
        }
        System.out.println();
    }

    /// 2) adaugre film nou in lista filmelor
    public Film[] adaugare_film_nou(Film[] filme)
    {
        /// Citirea datelor filmului

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numele noului film = ");
        String nume_film = scanner.nextLine();
        System.out.println();

        System.out.print("Intorduceti durata filmului = ");
        int durata = scanner.nextInt();
        System.out.println();

        System.out.println("Introduceti data filmului (zi + luna + an) = ");

        System.out.print("Ziua = ");
        int zi = scanner.nextInt();
        System.out.println();

        System.out.print("Luna = ");
        int luna = scanner.nextInt();
        System.out.println();

        System.out.print("Anul = ");
        int an = scanner.nextInt();
        System.out.println();

        System.out.println("Introduceti ora (h + min) la care va fi difuzat filmul = ");

        System.out.print("Ora = ");
        int ora = scanner.nextInt();
        System.out.println();

        System.out.print("Min = ");
        int min = scanner.nextInt();
        System.out.println();

        System.out.print("Introduceti tipul filmului = ");
        String tip = scanner.next();
        System.out.println();

        System.out.print("Introduceti pretul filmului = ");
        double pret_film = scanner.nextDouble();
        System.out.println();

        Film f = new Film(nume_film, durata, zi, luna, an, ora, min, tip, pret_film);

        int n = filme.length;

        Film[] movies = new Film[n + 1];

        System.arraycopy(filme, 0, movies, 0, n);

        movies[n] = f;

        return movies;

    }

    /// 3) creare bilet nou
    public Bilet creare_bilet(Film[] filme, int day, int month, int year)
    {
        Scanner scanner = new Scanner(System.in);
        Servicii servicii = new Servicii();

        /// afisam lista filmelor disponibile
        servicii.lista_filmelor_disponibile(filme, day, month, year);

        /// datele generale ale biletului

        System.out.print("Introduceti numele filmului dorit = ");
        String movie_name = scanner.nextLine();
        System.out.println();

        int pozitie = 0;

        for (int j = 0; j < filme.length; j++) {
            if (movie_name.compareTo(filme[j].getNume_film()) == 0) {
                pozitie = j;
            }
        }

        System.out.print("Sala = ");
        int sala = scanner.nextInt();
        System.out.println();

        System.out.print("Rand = ");
        int rand = scanner.nextInt();
        System.out.println();

        System.out.print("Loc = ");
        int loc = scanner.nextInt();
        System.out.println();

        System.out.print("Introduceti tipul biletului (2D / 3D / VIP) = ");
        String linie = scanner.next();
        System.out.println();
        scanner.nextLine();

        switch (linie)
        {
            case "2D" -> {

                /// cream biletul cu toate datele specificate
                Bilet ticket = new Bilet_2D(0, sala, rand, loc, filme[pozitie]);

                /// setam pretul calculat dupa formula
                ticket.setPret(ticket.calcul_pret(filme[pozitie].getPret_film()));

                return ticket;

            }
            case "3D" -> {

                /// cream biletul cu toate datele specificate
                Bilet ticket = new Bilet_3D(0, sala, rand, loc, filme[pozitie]);

                /// setam pretul calculat dupa formula
                ticket.setPret(ticket.calcul_pret(filme[pozitie].getPret_film()));

                return ticket;

            }
            case "VIP" -> {

                /// cream biletul cu toate datele specificate
                Bilet ticket = new Bilet_VIP(0, sala, rand, loc, filme[pozitie]);

                /// setam pretul calculat dupa formula
                ticket.setPret(ticket.calcul_pret(filme[pozitie].getPret_film()));

                return ticket;

            }
            default -> {
                return null;
            }
        }

    }

    /// selectare tip persoana + citire date persoana
    public Persoana creare_persoana()
    {
        Scanner scanner = new Scanner(System.in);
        Persoana p;

        System.out.print("Introduceti categoria dumneavoastra : (Student / Elev / Pensionar / Adult) = ");
        String categorie = scanner.next();
        System.out.println();
        scanner.nextLine();

        while(!Validari.validare_categorie(categorie))
        {
            System.out.print("Categoria introdusa este invalida ! Reincercati = ");
            System.out.println();
            System.out.println();

            System.out.print("Introduceti categoria dumneavoastra : (Student / Elev / Pensionar / Adult) = ");
            categorie = scanner.next();
            System.out.println();
        }

        /// datele generale ale persoanei

        System.out.print("Nume complet = ");
        String nume = scanner.next();
        System.out.println();
        scanner.nextLine();

        System.out.print("Varsta = ");
        int varsta = scanner.nextInt();
        System.out.println();

        while(!Validari.validare_varsta(varsta))
        {
            System.out.print("Varsta introdusa este invalida ! Reincercati = ");
            System.out.println();
            System.out.println();

            System.out.print("Varsta = ");
            varsta = scanner.nextInt();
            System.out.println();
        }

        System.out.print("Genul [M/F] = ");
        String gen = scanner.next();
        System.out.println();
        scanner.nextLine();

        while(!Validari.validare_gen(gen))
        {
            System.out.print("Genul introdus este invalid ! Reincercati = ");
            System.out.println();
            System.out.println();

            System.out.print("Genul [M/F] = ");
            gen = scanner.next();
            System.out.println();
            scanner.nextLine();
        }

        System.out.print("Adresa de e-mail = ");
        String email = scanner.next();
        System.out.println();
        scanner.nextLine();

        while(!Validari.validare_email(email))
        {
            System.out.print("Adresa de e-mail introdusa este invalida ! Reincercati = ");
            System.out.println();
            System.out.println();

            System.out.print("Adresa de e-mail = ");
            email = scanner.next();
            System.out.println();
            scanner.nextLine();
        }

        System.out.print("Telefon = ");
        String telefon = scanner.next();
        System.out.println();
        scanner.nextLine();

        while(!Validari.validare_telefon(telefon))
        {
            System.out.print("Numarul de telefon introdus este invalid ! Reincercati = ");
            System.out.println();
            System.out.println();

            System.out.print("Telefon = ");
            telefon = scanner.next();
            System.out.println();
            scanner.nextLine();
        }

        /// date particulare

        switch (categorie)
        {
            case "Student" -> {

                System.out.print("Facultate = ");
                String facultate = scanner.next();
                System.out.println();
                scanner.nextLine();

                System.out.print("An de studiu = ");
                int an_studiu = scanner.nextInt();
                System.out.println();

                p = new Student(nume, varsta, gen, email, telefon, facultate, an_studiu);

            }
            case "Elev" -> {

                System.out.print("Clasa = ");
                int clasa = scanner.nextInt();
                System.out.println();

                while(!Validari.validare_clasa(clasa))
                {
                    System.out.print("Clasa introdusa este invalida ! Reincercati = ");
                    System.out.println();

                    System.out.print("Clasa = ");
                    clasa = scanner.nextInt();
                    System.out.println();
                }

                p = new Elev(nume, varsta, gen, email, telefon, clasa);

            }
            case "Pensionar" -> {

                System.out.print("An pensionare = ");
                int an_pensionare = scanner.nextInt();
                System.out.println();

                p = new Pensionar(nume, varsta, gen, email, telefon, an_pensionare);

            }
            case "Adult" -> {

                p = new Adult(nume, varsta, gen, email, telefon);
            }
            default -> {
                p = null;
            }
        }
        return p;
    }

    /// 4) aplicarea discounturilor in functie de tipul utilizatorului
    /// 30% discount pentru Elevi (extra 5 lei reducere pentru Elevii din clasa a 8-a si a 12-a)
    /// 20% discount pentru Studenti (extra 5 lei reducere pentru Studentii din anul 1)
    /// 15% discount pentru Pensionari

    public void aplicare_discount(Persoana p)
    {
        if(p.getBilete() == null)
        {
            System.out.println("Nu aveti bilete in cos !");
            System.out.println();
        }
        else {
            /// cazul Persoane.Elev
            if (p instanceof Elev) {
                if (((Elev) p).getClasa() == 12 || ((Elev) p).getClasa() == 8) {
                    p.aplica_discount(5);
                } else {
                    p.aplica_discount(0);
                }
            }

            /// cazul Persoane.Student
            if (p instanceof Student) {
                if (((Student) p).getAn_studiu() == 1) {
                    p.aplica_discount(5);
                } else {
                    p.aplica_discount(0);
                }
            }

            /// Cazul Persoane.Pensionar
            if (p instanceof Pensionar)
                p.aplica_discount(0);

            System.out.println("Discount-ul a fost aplicat cu succes !");
        }

    }

    /// 5) Afisarea biletelor din cos

    public void afisare_bilete(Persoana p)
    {
        if(p.getBilete() == null)
        {
            System.out.println("Nu aveti bilete in cos !");
            System.out.println();
        }
        else {
            int count = 1;
            for (Bilet bilet : p.getBilete()) {
                System.out.println("Detaliile biletului " + count + " :");
                System.out.println("Pret final = " + bilet.getPret() + " lei");
                System.out.println("Sala = " + bilet.getSala());
                System.out.println("Rândul = " + bilet.getRand());
                System.out.println("Locul = " + bilet.getLoc());

                if (bilet instanceof Bilet_2D)
                    System.out.println("Tip bilet = 2D");
                if (bilet instanceof Bilet_3D)
                    System.out.println("Tip bilet = 3D");
                if (bilet instanceof Bilet_VIP)
                    System.out.println("Tip bilet = VIP");

                System.out.println("Film = " + bilet.getFilm().getNume_film());

                System.out.println();
                count++;
            }
        }
    }

    /// 6) sortarea biletelor utilizatorului dupa pret, iar daca pretul este egal,atunci vom sorta lexicografic dupa numele filmului.
    /// Clasa Bilete.Bilet implementeaza interfata Comparable si va da Override metodei compareTo, pentru a putea folosi functia Arrays.sort

    public void sortare_bilete(Persoana p)
    {
        if(p.getBilete() == null)
        {
            System.out.println("Nu aveti bilete in cos !");
            System.out.println();
        }
        else {
            Bilet[] bilete = p.getBilete();
            Arrays.sort(bilete);

            System.out.println("Biletele dumneavoastra au fost ordonate dupa pret !");
        }
    }

    /// 7) Verificare promotie
    public void verificare_promotie(Persoana p)
    {
        if(p.getBilete() == null)
        {
            System.out.println("Nu aveti bilete in cos !");
            System.out.println();
        }
        else {
            Scanner scanner = new Scanner(System.in);

            Bilet[] tickets = p.getBilete();
            int count = 0;

            Film film = tickets[0].getFilm();

            int tip_bilete = 0;

            if (tickets[0] instanceof Bilet_2D)
                tip_bilete = 1;
            else {
                if (tickets[0] instanceof Bilet_3D)
                    tip_bilete = 2;
                else {
                    if (tickets[0] instanceof Bilet_VIP)
                        tip_bilete = 3;
                }
            }

            int ok = 1;

            for (Bilet ticket : tickets) {
                count++;
                if (ticket.getFilm().compareTo(film) == 0) {
                    if ((ticket instanceof Bilet_2D) && tip_bilete != 1) {
                        ok = 0;
                        break;
                    }
                    if ((ticket instanceof Bilet_3D) && tip_bilete != 2) {
                        ok = 0;
                        break;
                    }
                    if ((ticket instanceof Bilet_VIP) && tip_bilete != 3) {
                        ok = 0;
                        break;
                    }
                } else {
                    ok = 0;
                    break;
                }
            }

            Bilet ticket;

            if (count >= 2 && ok == 1) {
                System.out.println("Felicitari ! Deoarece ati achizitionat mai mult de 2 bilete de acelasi tip la filmul " + film.getNume_film() + " ati primit un bilet gratuit !");
                System.out.println();
                /// citim datele noului bilet (pretul va fi 0 si filmul va fi "film")

                System.out.println("Detaliile biletului bonus");
                System.out.println();

                System.out.print("Sala = ");
                int sala = scanner.nextInt();
                System.out.println();

                System.out.print("Rand = ");
                int rand = scanner.nextInt();
                System.out.println();

                System.out.print("Loc = ");
                int loc = scanner.nextInt();
                System.out.println();

                if (tip_bilete == 1)
                    ticket = new Bilet_2D(0, sala, rand, loc, film);
                else {
                    if (tip_bilete == 2)
                        ticket = new Bilet_3D(0, sala, rand, loc, film);
                    else {
                        if (tip_bilete == 3)
                            ticket = new Bilet_VIP(0, sala, rand, loc, film);
                        else
                            ticket = null;
                    }
                }

                int n = tickets.length;

                Bilet[] tickets_copy = new Bilet[n + 1];

                System.arraycopy(tickets, 0, tickets_copy, 0, n);

                tickets_copy[n] = ticket;

                p.setBilete(tickets_copy);

            } else {
                System.out.println("Biletele din cosul dumneavoastra de cumparaturi nu se incadreaza in promotie !");
                System.out.println();
            }
        }
    }

    /// 8) Meniu bar
    public double cost_bar(double[] lista_produse)
    {
        double Total = 0;

        for(double cost : lista_produse)
            Total += cost;

        return Total;
    }


    /// 9) Stergere Bilet
    public void stergere_bilet(Persoana p, int poz)
    {

        Bilet[] tickets = p.getBilete();

        for (int i = poz; i < tickets.length - 1; i++)
            tickets[i] = tickets[i + 1];

        Bilet[] updated_tickets = new Bilet[tickets.length - 1];

        System.arraycopy(tickets, 0, updated_tickets, 0, updated_tickets.length);

        p.setBilete(updated_tickets);

    }

    /// 10) Afisare suma totoala de plata

    public double total_plata(Persoana p, double cost_total)
    {
        double total = 0;

        if(p.getBilete() == null)
            return cost_total;
        else {
            Bilet[] tickets = p.getBilete();

            for (Bilet ticket : tickets) {
                total += ticket.getPret();
            }

            return total + cost_total;
        }
    }

}
