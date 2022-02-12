public class Employee{
    private int num;
    private String name;
    private String surname;
    private Email email;
    private Email lastEmail;
    Employee(int num, String name, String surname){
        this.num=num;
        this.name=name;
        this.surname=surname;
    }
    public void print(){
        System.out.println("Employee: "+name+", "+surname);
    }
    public void setEmail(String email){
        this.email=new Email(email);
    }
    public Email getEmail(){
        return this.email;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public void setLastEmail(String str){
        lastEmail=new Email(str);
    }
    public Email getLastEmailMessage(){
        return lastEmail;
    }
    public void setLastEmailFrom(Employee emp){
        lastEmail.setFrom(emp);
    }
}
