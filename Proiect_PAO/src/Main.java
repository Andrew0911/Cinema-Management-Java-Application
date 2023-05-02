import Bilete.Bilet;
import Filme.Film;
import Persoane.Persoana;

import java.util.*;
public class Main
{

    /// FUNCTIONALITATILE APLICATIEI :
    /// 1) afisarea filmelor disponibile
    /// 2) adaugare film nou in lista filmelor
    /// 3) Adaugare bilete in cosul de cumparaturi
    /// 4) aplicarea discounturilor in functie de tipul utilizatorului
    /// 5) Afisarea biletelor cumparate
    /// 6) sortarea biletelor utilizatorului dupa pret, iar daca pretul este egal,atunci vom sorta lexicografic dupa numele filmului.
    /// 7) Daca utilizatorul cumpara 2 sau mai multe bilete de acelasi tip la acelasi film, va primi un bilet cadou
    /// 8) Meniu Bar
    /// 9) Stergere bilet
    /// 10) Afisare suma totala de plata


    public static void main(String[] args)
    {
        Servicii servicii = new Servicii();
        Scanner scanner = new Scanner(System.in);

        Film[] filme = {
                new Film("Harry Potter", 120, 30, 4, 2023, 16, 30, "SF", 30),
                new Film("Creed III", 116, 17, 8, 2023, 19, 0, "Drama", 25),
                new Film("Avatar 2", 183, 5, 5, 2023, 18, 45, "SF", 40),
                new Film("Titanic", 158, 7, 4, 2023, 17, 35, "Drama", 30),
                new Film("Fast & Furious 8", 105, 8, 12, 2023, 14, 45, "Actiune", 20),
                new Film("Black Panther", 96, 20, 7, 2023, 19, 30, "Actiune", 50),
                new Film("The Nun", 104, 26, 8, 2024, 13, 45, "Horror", 50)
        };

        System.out.println();
        System.out.println("Bun venit ! Pentru a putea utiliza aplicatia trebuie mai intai sa va inregistrati, completand datele dvs personale ");
        System.out.println();

        Persoana p = servicii.creare_persoana();
        System.out.println("Inregistrarea a reusit !");
        System.out.println();

        System.out.println("Functionalitatile aplicatiei : ");
        System.out.println();
        int caz = 1;
        int day = 0, month = 0, year = 0;
        double cost_total = 0;

        while(caz != 0) {
            
            servicii.afisare_meniu();
            System.out.println();

            System.out.print("Alegeti optiunea = ");
            caz = scanner.nextInt();
            System.out.println();


            switch (caz) {
                case 0 -> {
                    System.out.println("Multumim ca ati ales cinematograful nostru ! O zi buna !");
                    System.out.println();
                }
                case 1 -> {
                    if (day == 0 && month == 0 && year == 0)
                        servicii.lista_filmelor_disponibile(filme, 0, 0, 0);
                    else
                        servicii.lista_filmelor_disponibile(filme, day, month, year);
                }
                case 2 -> {
                    filme = servicii.adaugare_film_nou(filme);
                    System.out.println("Filmul a fost adaugat cu succes !");
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Introduceti data pentru care doriti sa achizitionati bilete ");

                    System.out.print("Ziua = ");
                    day = scanner.nextInt();
                    System.out.println();

                    System.out.print("Luna = ");
                    month = scanner.nextInt();
                    System.out.println();

                    System.out.print("Anul = ");
                    year = scanner.nextInt();
                    System.out.println();

                    System.out.print("Introduceti numarul de bilete pe care doriti sa le achizitionati = ");
                    int n = scanner.nextInt();
                    System.out.println();
                    scanner.nextLine();
                    Bilet[] bilete = new Bilet[n];

                    /// adaugare n bilete in vectorul persoanei
                    for (int i = 0; i < n; i++) {
                        bilete[i] = servicii.creare_bilet(filme, day, month, year);
                    }

                    p.setBilete(bilete);

                    System.out.println("Biletele dumneavoastra au fost adaugate in cos !");
                    System.out.println();
                }
                case 4 -> {
                    servicii.aplicare_discount(p);
                    System.out.println();
                }
                case 5 -> {
                    servicii.afisare_bilete(p);
                    System.out.println();
                }
                case 6 -> {
                    servicii.sortare_bilete(p);
                    System.out.println();
                }
                case 7 -> {

                    servicii.verificare_promotie(p);
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("Lista bar :");
                    System.out.println();

                    System.out.println("1) Popcorn -> 15 lei");
                    System.out.println("2) Apa -> 5 lei");
                    System.out.println("3) Ciocolata -> 10 lei");
                    System.out.println("4) Coca-Cola -> 7 lei");
                    System.out.println("5) M&M's -> 8 lei");
                    System.out.println("6) Nachos -> 17.5 lei");

                    System.out.println();
                    System.out.print("Numarul de produse dorite = ");
                    int nr = scanner.nextInt();
                    System.out.println();

                    double[] lista_produse = new double[nr];
                    for (int i = 0; i < lista_produse.length; i++) {
                        System.out.print("Produsul " + (i + 1) + " = ");

                        String produs = scanner.next();
                        System.out.println();
                        scanner.nextLine();

                        if (produs.compareTo("Popcorn") == 0)
                            lista_produse[i] = 15;
                        if (produs.compareTo("Apa") == 0)
                            lista_produse[i] = 5;
                        if (produs.compareTo("Ciocolata") == 0)
                            lista_produse[i] = 10;
                        if (produs.compareTo("M&M's") == 0)
                            lista_produse[i] = 8;
                        if (produs.compareTo("Coca-Cola") == 0)
                            lista_produse[i] = 7;
                        if (produs.compareTo("Nachos") == 0)
                            lista_produse[i] = 17.5;

                    }
                    System.out.println();

                    cost_total = servicii.cost_bar(lista_produse);
                    if (cost_total > 0) {
                        System.out.println("Am adaugat produsele dorite in cos !");
                        System.out.println();
                    }

                }
                case 9 -> {

                    if (p.getBilete() == null) {
                        System.out.println("Nu aveti bilete in cos !");
                        System.out.println();
                    } else {
                        System.out.print("Indicele biletului de sters = ");
                        int poz = scanner.nextInt();
                        System.out.println();

                        servicii.stergere_bilet(p, poz - 1);

                        System.out.println("Biletul a fost sters cu succes din cos !");
                        System.out.println();
                    }
                }
                case 10 -> {
                    System.out.print("Total plata = " + servicii.total_plata(p, cost_total) + " lei");
                    System.out.println();
                    System.out.println();
                }
                default -> {
                    System.out.print("Optiune invalida !");
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }
}