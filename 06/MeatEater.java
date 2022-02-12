public abstract class MeatEater implements Animal{
    private String name;
    private int weight;
    private int age;
    private String type;

    MeatEater(String name, int weight, int age, String type){
        this.name=name;
        this.weight=weight;
        this.age=age;
        this.type=type;
    }

    @Override
    public String toString(){
        return "imie: "+this.name+", waga: "+this.weight+", wiek: "+this.age+", typ: "+this.type;
    }

    public void setName(String name){
        this.name=name;
    }
    public void eatMeat(){
        System.out.println(this.animalSpecies()+" je mieso");
    }
    public int compare(Object other){
        if(other!=null && other.getClass()==this.getClass()){
            if(type.equals(((MeatEater)other).type) && name.equals(((MeatEater)other).name) && weight==((MeatEater)other).weight && age==((MeatEater)other).age) return 0;
        }
        return -1;
    }
}