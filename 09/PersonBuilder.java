public class PersonBuilder{
    private String name;
    private String surname;
    private int age;
    public PersonBuilder name(String name){
        this.name=name;
        return this;
    }
    public PersonBuilder surname(String surname){
        this.surname=surname;
        return this;
    }
    public PersonBuilder age(int age){
        this.age=age;
        return this;
    }
    public Person build(){
        return new Person(name, surname, age);
    }
}