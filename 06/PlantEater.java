public abstract class PlantEater implements Animal{
    private String name;
    private int weight;
    private int age;

    PlantEater(){}

    PlantEater(String name){
        this.name=name;
    }

    PlantEater(String name, int weight, int age){
        this.name=name;
        this.weight=weight;
        this.age=age;
    }
    @Override
    public String toString(){
        return "imie: "+this.name+", waga: "+this.weight+", wiek: "+this.age;
    }
    public void eatPlant(){
        System.out.println(animalSpecies()+" je ziarna");
    }

    public void setName(String name){
        this.name=name;
    }
    public int compare(Object other){
        if(other!=null && other.getClass()==this.getClass()){
            if(name.equals(((PlantEater)other).name) && weight==((PlantEater)other).weight && age==((PlantEater)other).age) return 0;
        }
        return -1;
    }
}