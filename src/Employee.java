

// Course work 1.0
// @ Aleksandar Zubanov
// 2022/08/17

public class Employee {

    private final String name;
    private final String patronymicName;
    private final String surname;
    private int department;
    private double salary;
    private final Integer id;

    private static int counter = 1;

    public Employee(String name, String surname, String patronymicName, double salary,
                    int department) {
        this.name = name;
        this.patronymicName = patronymicName;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return " " + name +
                " " + patronymicName +
                " " + surname +
                ", department number: " + department +
                ", salary: " + salary +
                ", Id: " + id +
                ".";
    }
}
