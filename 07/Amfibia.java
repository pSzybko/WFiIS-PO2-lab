public class Amfibia extends SamochodOsobowy implements PojazdPlywajacy{
    Amfibia(String name){
        super(name);
    }
    @Override
    public String type(){
        return "amfibia";
    }
    @Override
    public String toString(){
        return this.type();
    }
    public void plyn(){
        if(ignition)
            System.out.println("amfibia plynie");
        else
            System.out.println("amfibia nie moze plynac bo jest wylaczona");
    }
}