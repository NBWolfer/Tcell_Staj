import Classes.Employee;
import Classes.Engineer;
import Classes.Position;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        Random random = new Random();



        Engineer engineer = new Engineer("Enes", "Cevik", 22, random.nextInt(100, 999), Position.JUNIOR, "Data Engineer");

        AtomicReference<Employee> employee = new AtomicReference<>(engineer);

        System.out.println(engineer.getSpecialization());

        System.out.println(engineer.getFullName());
        System.out.println(employee.get().getFullName());
        System.out.println(engineer.getAge());
        System.out.println(employee.get().getAge());

        int id = engineer.createId();
        System.out.println(id);
    }
}