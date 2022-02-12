import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//Napisz klasy ImmutablePerson, ImmutablePersonWrapper
//obiekty powstawłe z klasy ImmutablePerson powinny byc niemutowalne( co sprawdzają poszczegolne metody wypisujace na ekran)
//Przy każdym wypisywaniu w komentarzu znajduje się napis, który powinien zostać wyświetlony przez program
//Tego pliku nie wolno zmieniac!
//Kazda klasa powinna miec osobny plik
//Do programu należy załączyć poniższy plik

// wskazowki
// - w razie watpliwosci co powinna robic pojedyncza metoda prosze pytac


public class Lab4 {
    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = "5-Jan-2000";
        Date dateOfBirth = formatter.parse(date);
        String firstName = "Jan";
        String surname = "Nowak";
        ImmutablePerson immutablePerson = new ImmutablePerson(firstName, surname, dateOfBirth);
        System.out.println(immutablePerson.getInformation()); //Imie: Jan nazwisko: Nowak data urodzenia: Wed Jan 05 00:00:00 CET 2000

        dateOfBirth.setMonth(Calendar.FEBRUARY);
        System.out.println(immutablePerson.getInformation()); //Imie: Jan nazwisko: Nowak data urodzenia: Wed Jan 05 00:00:00 CET 2000

        Date dateOfBirthCopy = immutablePerson.getDateOfBirth();
        dateOfBirthCopy.setMonth(Calendar.FEBRUARY);

        System.out.println(immutablePerson.getInformation()); //Imie: Jan nazwisko: Nowak data urodzenia: Wed Jan 05 00:00:00 CET 2000

        new ImmutablePersonWrapper(immutablePerson).printInfoAboutPerson("good"); //Jan is good
        new ImmutablePersonWrapper(immutablePerson).printInfoAboutPerson(true); //Jan is having good time:true

        ImmutablePerson clone = immutablePerson.clone();
        System.out.println(clone == immutablePerson); //false
        System.out.println(clone.getFirstName().equals(immutablePerson.getFirstName())); //true
        System.out.println(clone.equals(immutablePerson)); //false
    }
}
