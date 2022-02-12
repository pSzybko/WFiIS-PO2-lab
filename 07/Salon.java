import java.util.ArrayList;
import java.util.List;
public class Salon{
    private String name;
    private ArrayList<Pojazd> arr;
    Salon(String name){
        this.name=name;
        this.arr= new ArrayList<Pojazd>();
    }
    Salon(Salon other, String name){
        this.name=name;
        this.arr= new ArrayList<Pojazd>(other.arr);
    }
    public void dodajPojazd(Pojazd p){
        this.arr.add(p);
        System.out.println("dodaje nowy pojazd");
    }
    public void wypiszWszystkiePojazdy(){
        for(Pojazd i : arr){
            System.out.print(i+", ");
        }
        System.out.println();
    }
    public void usunPojazd(Pojazd p){
        arr.remove(p);
        System.out.println("usuwam "+p+" z salon "+name);
    }
    public void zawieraPojazd(Pojazd p){
        System.out.println(arr.contains(p));
    }
}