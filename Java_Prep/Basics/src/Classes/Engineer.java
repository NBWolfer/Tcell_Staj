package Classes;

import java.util.Random;

public class Engineer extends Employee implements TestFunctions{
    private String specialization;

    public Engineer(String name, String surname, int age, int id, Position position, String specialization) {
        super(name, surname, age, id, position);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getClassName() {
        return "Engineer";
    }

    public int createId(){
        Random random = new Random();
        return random.nextInt(1000000, 9999999);
    }
}
