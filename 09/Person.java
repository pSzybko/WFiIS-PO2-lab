class PersonException extends Exception{
    PersonException(String s){
        System.out.println(s);
    }
}

public class Person{
    private String name;
    private String surname;
    private int age;
    Person(String name, String surname, int age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    @Override
    public String toString(){
        return "Person{name='"+name+"', surname='"+surname+"', age="+age+"}";
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(name, surname, age);
    }
    @Override
    public boolean equals(Object other){
        if(this==other) return true;
        if(other instanceof Person){
            Person p2=((Person)(other));
            if(!name.equals(p2.name)) return false;
            if(!surname.equals(p2.surname)) return false;
            if(age!=p2.age) return false;
            return true;
        }
        return false;
    }
    public int getAge(){
        return age;
    }
    public void checkAge() throws PersonException{
        if(age<18)
            throw new PersonException(this.toString()+" cannot drink alcohol");
        else
            System.out.println("Can drink");
    }
}