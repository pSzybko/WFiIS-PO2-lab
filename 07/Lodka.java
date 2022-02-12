public class Lodka extends Pojazd implements PojazdPlywajacy{
    Lodka(String name){
        super(name);
    }
    @Override
    public String type(){
        return "lodka";
    }
    public void plyn(){
        if(ignition)
            System.out.println("lodka plynie");
        else
            System.out.println("lodka nie moze plynac bo jest wylaczona");
    }
    @Override
    public String toString(){
        return super.toString();
    }
}