public class ImmutablePersonWrapper{
    private final ImmutablePerson person;

    ImmutablePersonWrapper(ImmutablePerson person){
        this.person=person;
    }
    public void printInfoAboutPerson(String str){
        System.out.println(person.getFirstName()+" is "+str);
    }
    public void printInfoAboutPerson(boolean flag){
        System.out.println(person.getFirstName()+" is having good time:"+flag);
    }
}