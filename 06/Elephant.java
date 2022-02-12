public class Elephant extends PlantEater{
    Elephant(String name, int weight, int age){
        super(name, weight, age);
    }
    @Override
    public String toString(){
        return "zwierze: slon, "+super.toString();
    }
    public String animalSpecies(){
        return "Slon";
    }
}