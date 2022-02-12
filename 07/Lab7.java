

public class Lab7 {
    public static void main(String[] args) {
        Pojazd samochodOsobowy = new SamochodOsobowy("tesla");
        Pojazd lodka = new Lodka("halina");
        Pojazd amfibia = new Amfibia("dar pomorza");

        Starter.start(samochodOsobowy); // samochod tesla uruchamia silnik
        Starter.start(lodka); // lodka halina uruchamia silnik
        Starter.start(amfibia); // amfibia dar pomorza uruchamia silnik

        Salon salon = new Salon("salon pierwszy");
        salon.dodajPojazd(samochodOsobowy); // dodaje nowy pojazd
        salon.dodajPojazd(lodka); // dodaje nowy pojazd
        salon.dodajPojazd(amfibia); // dodaje nowy pojazd

        salon.wypiszWszystkiePojazdy(); // samochodOsobowy, lodka, amfibia
        salon.usunPojazd(lodka); // usuwam lodka
        salon.wypiszWszystkiePojazdy(); // samochodOsobowy, amfibia

        salon.zawieraPojazd(lodka); // false
        salon.zawieraPojazd(samochodOsobowy); // true

        Salon salon2 = new Salon(salon, "salon drugi");
        salon.usunPojazd(samochodOsobowy); // usuwam samochod tesla z salon pierwszy

        salon2.wypiszWszystkiePojazdy(); // samochodOsobowy, amfibia

        Amfibia amfibia2 = new Amfibia("dar pomorza v2");
        amfibia2.jedz(); // amfibia jedzie
        amfibia2.plyn(); // amfibia plynie

        Starter.start(lodka); // lodka zaczyna plynac

        Starter.stop(samochodOsobowy);// samochod tesla zatrzymuje silnik
        Starter.stop(lodka);// lodka halina zatrzymuje silnik
        Starter.stop(amfibia);// amfibia dar pomorza zatrzymuje silnik
        Starter.stop(lodka); // lodka przestaje plynac

        ((PojazdPlywajacy)lodka).plyn(); // lodka nie moze plynac bo nie jest wlaczona
    }
}
