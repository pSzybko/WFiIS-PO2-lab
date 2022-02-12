interface Obliczenia{
    int printOperation(Person p1, Person p2);
}

public class PersonPrinter{
    static public void print(Person ... p){
        for(int i=0; i<p.length; i++)
            System.out.print(p[i]);
        System.out.println();
    }
    public void printOperation(Person p1, Person p2, Obliczenia o){
        System.out.println(o.printOperation(p1, p2));
    }
    Obliczenia sum=(p1, p2)->{return p1.getAge()+p2.getAge();};
    Obliczenia multiply=(p1, p2)->{return p1.getAge()*p2.getAge();};
    public static void checkIfCanDrinkWithExceptionCatch(Person p){
        try{
            p.checkAge();
        }catch(PersonException e){}
        catch(Exception e){
            System.out.println("Zepsulo sie bardziej niz powinno!");
        }
    }
}