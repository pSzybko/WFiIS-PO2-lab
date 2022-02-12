
//Uwaga: wszystkie pola powinny być prywatne. 
//Proszę też korzystać z napisanych przez siebie metod oraz dziedziczenia -- jeśli dana funkcjonalność jest już zaimplementowana, to nie powtarzamy jej .
//Niezastosowanie się do tych wymagań będzie miało wpływ na ocenę
import java.util.ArrayList;
import java.util.List;

public class Lab6 {

    public static void main(String[] args) {
        Elephant elephant1 = new Elephant("el1", 7000, 11);
        System.out.println("Slon 1: " + elephant1); // Slon 1: 
                                                    // -zwierze:slon
                                                    // -imie: el1
                                                    // -waga: 7000
                                                    // -wiek: 11 

        Elephant elephant2 = new Elephant("el2", 6000, 7);

        Elephant elephant2TakiSam = new Elephant("el2", 6000, 7);

        Lion lion1 = new Lion("lion1", 100, 24, "albinos");
        System.out.println("Lew 1: " + elephant1); // Lew 1: 
                                                   // -zwierze: lew
                                                    // -imie: lion1
                                                    // -waga: 100
                                                    // -wiek: 24
                                                    // -typ:albinos 
        List<Elephant> elephants = new ArrayList<>();
        elephants.add(elephant1);
        elephants.add(elephant2);
        // elephants.add(lion1); // Odkomentowanie tej linijki powinno zakonczyc się błędem kompilacji

        List<Animal> animals = new ArrayList<>();
        animals.add(elephant1);
        animals.add(elephant2);
        animals.add(lion1);

        for(Animal animal : animals) {
             System.out.println(animal);
             System.out.println();
        }// wypisują się informacje o zwierzęciu

        System.out.println("Liczba sloni: " + elephants.size()); // Liczba sloni: 2
        System.out.println("Liczba zwierzat w zoo: " + animals.size()); // Liczba zwierzat w zoo: 3
        lion1.eatMeat(); // Lew je mieso...
        // lion1.eatPlant(); // Powinien polecieć wyjątek

        Parrot parrot1 = new Parrot();
        parrot1.setName("Ara");
        parrot1.eatPlant(); // Papuga je ziarna
        // parrot1.eatMeat(); // Powinien polecieć wyjątek
        List<MeatEater> meatEaters = new ArrayList<>();
        meatEaters.add(lion1);
        // meatEaters.add(parrot1); // Odkomentowanie tej linijki powinno zakonczyc się błędem kompilacji

        System.out.println(elephant2.compare(elephant2TakiSam)); //0
        parrot1.createEgg();// Papuga znosi jajko

        Canary canary = new Canary("canary");
        canary.createEgg();// Kanarek znosi jajko
        // lion1.createEgg(); //Powinien polecieć błąd że nie ma takiej metody(bo przecież nie znosi jajka)
    }

}