public class Starter{
    public static void start(Pojazd p){
        if(!p.getIgnition()){
            System.out.println(p+" "+p.getName()+" uruchamia silnik");
            p.switchIgnition();
        }
        else if(p instanceof PojazdPlywajacy){
            System.out.println(p+" "+p.getName()+" zaczyna plynac");
        }
        else{
            System.out.println(p+" "+p.getName()+" zaczyna jechac");
        }
    }
    public static void stop(Pojazd p){
        if(p.getIgnition()){
            System.out.println(p+" "+p.getName()+" zatrzymuje silnik");
            p.switchIgnition();
        }
        else if(p instanceof PojazdPlywajacy){
            System.out.println(p+" "+p.getName()+" przestaje plynac");
        }
        else{
            System.out.println(p+" "+p.getName()+" przestaje jechac");
        }
    }
}