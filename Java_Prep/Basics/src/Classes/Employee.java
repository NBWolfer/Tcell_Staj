package Classes;

public class Employee extends AbstractPerson {
    private int id;

    private Position position;

    public Employee(String name, String surname, int age, int id, Position position) {
        super(name, surname, age);
        this.id = id;
        this.position = position;
    }

    @Override
    public String getFullName() {
        return getName() + " " + getSurname();
    }
}
