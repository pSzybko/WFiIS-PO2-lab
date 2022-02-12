//Napisz klasy EmployeeManagementService, EmailService, Employee, Email, Department
//W klasach zaprojektuj odpowiednie pola i metody, które pozwolą na przeprowadzanie pewnych operacji na pracownikach
//Przy każdym wypisywaniu w komentarzu znajduje się napis, który powinien zostać wyświetlony przez program
//Tego pliku nie wolno zmieniac!
//Kazda klasa powinna miec osobny plik
//Do programu należy załączyć poniższy plik
//Department powinien zawierac 3 stałe niemodyfikowalne pola typu String (w razie pytan sluze pomoca)

// wskazowki
// - ostatniego otrzymanego maila mozna trzymac jako pole typu String w obiekcie klasy Employee
// - do przetrzymywania wszystkich pracownikow mozemy uzyc tablicy albo listy
// - w razie watpliwosci co powinna robic pojedyncza metoda prosze pytac

public class Lab3 {
    public static void main(String[] args) {
        EmployeeManagementService employeeManagementService = new EmployeeManagementService();
        EmailService emailService = new EmailService();

        Employee employeeJakub = new Employee(1, "Jakub", "Nowak");
        employeeManagementService.addNewEmployee(employeeJakub); //Employee added Jakub Nowak
        Employee employeeAdam = new Employee(2, "Adam", "Klak");
        employeeManagementService.addNewEmployee(employeeAdam);//Employee added Adam Klak
        Employee employeeJeremy = new Employee(3, "Jeremy", "Smith");
        employeeManagementService.addNewEmployee(employeeJeremy); //Employee added Jeremy Smith

        employeeManagementService.printAllEmployees();
//        Employee: Jakub , Nowak
//        Employee: Adam , Klak
//        Employee: Jeremy , Smith

        emailService.generateEmailForNewEmployee(employeeJakub, Department.DEVELOPERS);
        emailService.generateEmailForNewEmployee(employeeAdam, Department.MANAGEMENT);
        emailService.generateEmailForNewEmployee(employeeJeremy, Department.HR);

        System.out.println(employeeJakub.getEmail()); //Jakub.Nowak@DEVELOPERS.com

        employeeManagementService.changeEmail(employeeJakub, "new.email@test.com");

        System.out.println(employeeJakub.getEmail()); //new.email@test.com

        employeeManagementService.fireEmployee(employeeJakub);
        employeeManagementService.changeEmail(employeeJakub, "new.email@test.com"); // Nie ma takiego pracownika

        employeeManagementService.printAllEmployees();
//        Employee: Adam , Klak
//        Employee: Jeremy , Smith

        employeeManagementService.sendMailToAllEmployees("Przykladowa wiadomosc");
        System.out.println(employeeJakub.getLastEmailMessage()); // null
        System.out.println(employeeAdam.getLastEmailMessage().getMessage()); //Przykladowa wiadomosc
        System.out.println(employeeJeremy.getLastEmailMessage().getMessage()); //Przykladowa wiadomosc

        emailService.sendMail(employeeAdam, employeeJeremy, "siema");
        System.out.println(employeeJeremy.getLastEmailMessage().getFrom().getEmail()); //Adam.Klak@MANAGEMENT.com
        System.out.println(employeeJeremy.getLastEmailMessage().getMessage());//siema

    }
}
