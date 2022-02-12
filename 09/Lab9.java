import java.util.HashSet;
import java.util.Set;

public class Lab9 {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Set<Person> personSet = new HashSet<>();
        Person person1 = personBuilder.name("Adam").surname("Nowak").age(17).build();
        Person person2 = personBuilder.name("Adam").surname("Nowak").age(17).build();
        System.out.println(person1); // Person{name='Adam', surname='Nowak', age=17}
        System.out.println(person2); // Person{name='Adam', surname='Nowak', age=17}
        personSet.add(person1);
        personSet.add(person2);
        System.out.println(personSet.size()); // 1

        PersonPrinter.print(); //
        PersonPrinter.print(person1); // Person{name='Adam', surname='Nowak', age=17}
        PersonPrinter.print(person2); // Person{name='Adam', surname='Nowak', age=17}
        PersonPrinter.print(person1, person2); //Person{name='Adam', surname='Nowak', age=17}Person{name='Adam', surname='Nowak', age=17}
        PersonPrinter.print(person1, person2, personBuilder.name("New").surname("Person").age(71).build()); // Person{name='Adam', surname='Nowak', age=17}Person{name='Adam', surname='Nowak', age=17}Person{name='New', surname='Person', age=71}

        // uzywamy lambd do napisania dzialan
        PersonPrinter personPrinter = new PersonPrinter();
        personPrinter.printOperation(person1, person2, personPrinter.sum); // 34
        personPrinter.printOperation(person1, person2, personPrinter.multiply); // 289

    //     //Tutaj chodzi w pierwszym przypadku o przekazanie info o osobie do konstruktora Exception i wypisanie informacji,
    //     // w drugiej linijce jest co powinno sie znalezc w miejscu lapania exception
       PersonPrinter.checkIfCanDrinkWithExceptionCatch(person1);
    //    // Person{name='Adam', surname='Nowak', age=17} cannot drink alcohol
    //     // Catch Exception
       PersonPrinter.checkIfCanDrinkWithExceptionCatch(personBuilder.name("New").surname("Person").age(71).build()); // Can drink
    }
}
