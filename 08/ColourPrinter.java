enum kolory{
    RED("czerwony"),
    GREEN("zielony"),
    YELLOW("zolty"),
    BLUE("niebieski");

    private final String nazwa;

    kolory(String kolor){
        nazwa=kolor;
    }
    public String getNazwa(){
        return nazwa;
    }
}

public class ColourPrinter{
    public static void printColours(){
        for(kolory k: kolory.values()){
            System.out.println("Kolor "+k+" po polsku: "+k.getNazwa());
        }
    }
    public static void printGetNameColours(){
        for(kolory k: kolory.values()){
            System.out.println(k.getNazwa());
        }
    }
    public static void printSaySomethingColours(){
        for(kolory k: kolory.values()){
            System.out.println("Kolor to "+k.getNazwa());
        }
    }
}