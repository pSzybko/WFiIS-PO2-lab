public class Email{
    private String email;
    private Employee from;
    
    Email(String email){
        this.email=email;
    }
    public String toString(){
        return this.email;
    }
    public String getMessage(){
        return this.email;
    }
    public void setFrom(Employee emp){
        from=emp;
    }
    public Employee getFrom(){
        return this.from;
    }
}
