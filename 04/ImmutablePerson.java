import java.util.Date;

public class ImmutablePerson{
    private final String firstName;
    private final String surname;
    private final Date dateOfBirth;

    ImmutablePerson(String firstName, String surname, Date dateOfBirth){
        this.firstName=firstName;
        this.surname=surname;
        this.dateOfBirth=(Date)(dateOfBirth.clone());
    }

    public String getInformation(){
        return "Imie: "+this.firstName+" nazwisko: "+this.surname+" data urodzenia: "+this.dateOfBirth;
    }
    public Date getDateOfBirth(){
        return (Date)(this.dateOfBirth.clone());
    }
    @Override
    public ImmutablePerson clone(){
        return (new ImmutablePerson(this.firstName, this.surname, this.dateOfBirth));
    }
    public String getFirstName(){
        return firstName;
    }
}