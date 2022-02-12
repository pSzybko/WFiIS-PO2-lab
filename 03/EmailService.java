public class EmailService{
    public void generateEmailForNewEmployee(Employee emp, String str){
        emp.setEmail(emp.getName()+"."+emp.getSurname()+"@"+str+".com");
    }
    public void sendMail(Employee emp1, Employee emp2, String str){
        emp2.setLastEmail(str);
        emp2.setLastEmailFrom(emp1);
    }
}
