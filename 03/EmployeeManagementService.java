import java.util.ArrayList;
class EmployeeManagementService{
    ArrayList<Employee> arr=new ArrayList<Employee>();
    public void addNewEmployee(Employee emp){
        arr.add(emp);
        System.out.println("Employee added "+emp.getName()+" "+emp.getSurname());
    }
    public void printAllEmployees(){
        for(Employee i : arr)
            i.print();
    }
    public void fireEmployee(Employee emp){
        if(arr.indexOf(emp)==-1) return;
        arr.remove(emp);
    }
    public void changeEmail(Employee emp, String str){
        if(arr.indexOf(emp)==-1){
            System.out.println("Nie ma takiego pracownika");
            return;
        }
        emp.setEmail(str);
    }
    public void sendMailToAllEmployees(String str){
        for(Employee i : arr)
            i.setLastEmail(str);
    }
}
