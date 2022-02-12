public class SamochodOsobowy extends Pojazd{
    SamochodOsobowy(String name){
        super(name);
    }
    @Override
    public String type(){
        return "samochodOsobowy";
    }
    @Override
    public String toString(){
        return "samochod";
    }
}