import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class PersonService{
    enum plec{
        KOBIETA, 
        MEZCZYZNA
    }
    static class Person{
        private String imie;
        private String nazwisko;
        private plec p; 
        private int wiek;
    
        Person(String imie, String nazwisko, plec p, int wiek){
            this.imie=imie;
            this.nazwisko=nazwisko;
            this.p=p;
            this.wiek=wiek;
        }
        @Override
        public String toString() {
            return imie+" "+nazwisko+" "+p.toString()+" "+wiek;
        }
    }
    private List<Person> arr=new ArrayList<>();

    public void addPerson(Person p){
        arr.add(p);
    }
    public List<Person> getListByPlec(plec plec){
        List<Person> res=arr.stream().filter(per -> per.p.equals(plec)).collect(Collectors.toList());
        return res;
    }
    public List<Person> getListByWiek(){
        List<Person> res=arr.stream().filter(per -> per.wiek>=18).collect(Collectors.toList());
        return res;
    }
    public List<Person> getListByNazwisko(String nazw){
        List<Person> res=arr.stream().filter(per -> per.nazwisko.equals(nazw)).collect(Collectors.toList());
        return res;
    }
    public List<Person> getListByImie(String im){
        List<Person> res=arr.stream().filter(per -> per.imie.equals(im)).collect(Collectors.toList());
        return res;
    }
    public int sumAge(){
        int res=arr.stream().mapToInt(per -> per.wiek).sum();
        return res;
    }
    public Map<String, Integer> getMap(){
        Map<String, Integer> res=arr.stream().collect(Collectors.toMap(per -> per.imie + per.nazwisko, per -> per.wiek));
        return res;
    }
    public List<Person> getListDoubleAge(){
        List<Person> res=arr.stream().map(per -> new Person(per.imie, per.nazwisko, per.p, 2*per.wiek)).collect(Collectors.toList());
        return res;
    }
    @Override
    public String toString() {
        String res="";
        for(Person p : arr){
            res+=p.toString()+"\n";
        }
        return res;
    }
    public static void main(String[] args) {
        Person p1=new Person("Jan", "Orzeł", plec.MEZCZYZNA, 12);
        System.out.println(p1);
        PersonService ps1=new PersonService();
        ps1.addPerson(p1);
        ps1.addPerson(new Person("Adam", "Abacki", plec.MEZCZYZNA, 25));
        ps1.addPerson(new Person("Ada", "Adacka", plec.KOBIETA, 28));
        ps1.addPerson(new Person("Bartosz", "Babacki", plec.MEZCZYZNA, 13));
        ps1.addPerson(new Person("Jan", "Jankowski", plec.MEZCZYZNA, 17));
        ps1.addPerson(new Person("Barbara", "Babacka", plec.KOBIETA, 60));
        ps1.addPerson(new Person("Ola", "Orzeł", plec.KOBIETA, 4));
        System.out.println("PersonService:");
        System.out.println(ps1);

        List<Person> listByPlec1=ps1.getListByPlec(plec.MEZCZYZNA);
        System.out.println("Mezczyzni z listy:");
        System.out.println(Arrays.toString(listByPlec1.toArray()));
        List<Person> listByPlec2=ps1.getListByPlec(plec.KOBIETA);
        System.out.println("Kobiety z listy:");
        System.out.println(Arrays.toString(listByPlec2.toArray()));
        List<Person> listByAge=ps1.getListByWiek();
        System.out.println("Pełnoletni z listy:");
        System.out.println(Arrays.toString(listByAge.toArray()));
        List<Person> listBySurname=ps1.getListByNazwisko("Orzeł");
        System.out.println("Osoby o nazwisku Orzeł z listy:");
        System.out.println(Arrays.toString(listBySurname.toArray()));
        List<Person> listByName=ps1.getListByImie("Jan");
        System.out.println("Osoby o imieniu Jan z listy:");
        System.out.println(Arrays.toString(listByName.toArray()));
        System.out.println("Łączny wiek osób: ");
        System.out.println(ps1.sumAge());
        System.out.println("Mapa klucz - imie+nazwisko  wartosc - wiek: ");
        Map<String, Integer> personMap=ps1.getMap();
        for(Map.Entry<String, Integer> entry : personMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().toString());
        }
        System.out.println("Lista osob z wiekiem pomnożonym razy 2");
        List<Person> listDoubleAge=ps1.getListDoubleAge();
        System.out.println(Arrays.toString(listDoubleAge.toArray()));
        System.out.println("Oryginał bez zmian:");
        System.out.println(ps1);
    }
}