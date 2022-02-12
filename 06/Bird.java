public abstract class Bird extends PlantEater{
    Bird() {}
    Bird(String name){
        super(name);
    }
    void createEgg(){
        System.out.println(animalSpecies()+" znosi jajko");
    }
}