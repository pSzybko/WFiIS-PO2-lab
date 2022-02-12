public class Lion extends MeatEater{
    Lion(String name, int weight, int age, String type){
        super(name, weight, age, type);
    }
    @Override
    public String toString(){
        return "zwierze: lew, "+super.toString();
    }
    public String animalSpecies(){
        return "Lew";
    }
}