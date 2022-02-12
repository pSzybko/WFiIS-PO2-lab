public abstract class Pojazd{
    protected String name;
    protected boolean ignition=false;
    Pojazd(String name){
        this.name=name;
    }
    Pojazd(Pojazd other){
        this.name=other.name;
    }
    @Override
    public String toString(){
        return this.type();
    }
    public String type(){
        return "pojazd";
    }
    public void switchIgnition(){
        ignition=!ignition;
    }
    public void jedz(){
        if(ignition)
            System.out.println(this.type()+" jedzie");
        else
            System.out.println(this.type()+" nie moze jechac bo nie jest wlaczona");
    }
    public boolean getIgnition(){
        return ignition;
    }
    public String getName(){
        return name;
    }
}