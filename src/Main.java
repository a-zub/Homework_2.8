// Course work 1.0
// @ Aleksandar Zubanov
// 2022/08/17

public class Main {


    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Петр", "Иванов", "Иванович", 35_000,
                1);
        Employee ivan = new Employee("Иван", "Иванов", "Иванович", 45_000,
                2);
        Employee sidorov = new Employee("Степан", "Сидоров", "Степанович", 23_000,
                3);
        Employee petrov = new Employee("Николай", "Петров", "Петрович", 46_000,
                5);
        Employee smirnov = new Employee("Олег", "Смирнов", "Васильевич", 33_000,
                4);
        Employee  vasin = new Employee("Андрей", "Васин", "Игоревич", 33_000,
                4);
        employeeBook.addEmployee(ivan);
        employeeBook.addEmployee(sidorov);
        employeeBook.addEmployee(petrov);
        employeeBook.addEmployee(smirnov);
        employeeBook.addEmployee(vasin);

        employeeBook.removeEmployee(1);
        employeeBook.changeSalary(ivan, 43_000);
        employeeBook.changeDepartment(ivan, 1);

        employeeBook.printEmployeesByDepartment();

        employeeBook.printAllEmployees();

        double totalSalaries = employeeBook.totalSalaries();
        System.out.printf("Сумма зарплат всех сотрудников за месяц:  %.3f%n", totalSalaries);

        Employee employeeWithSaMinSalary = employeeBook.findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithSaMinSalary);

        Employee employeeWithMaxSalary = employeeBook.findEmployeeMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaxSalary);

        double averageSalary = employeeBook.averageSalary();
        System.out.println("Средняя зарплата всех сотрудников за месяц: " + averageSalary);

        employeeBook.printFullNameEmployees();

        employeeBook.indexSalaries(10);
        System.out.println("После индексации: ");

        employeeBook.printAllEmployees();

        System.out.printf("Сотрудник с минимальной зарплатой из %d отдела: %s%n", 1, employeeBook.findEmployeeWithMinSalaryFromDepartment(1));
        System.out.printf("Сотрудник с максимальной зарплатой из %d отдела: %s%n", 2, employeeBook.findEmployeeWithMaxSalaryFromDepartment(2));
        System.out.printf("Сумма зарплат всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeBook.totalSalariesForDepartment(3));
        System.out.printf("Средняя зарплата всех сотрудников  за месяц из отдела %d: %.3f%n", 4, employeeBook.averageSalaryForDepartment(4));

        employeeBook.indexSalariesForDepartment(5, 1);
        System.out.println("После индексации для отдела " + 1);
        employeeBook.printEmployeesWithSalaryLessThan(55_00);
        employeeBook.printEmployeesWithSalaryGreaterOrEqualThen(55_000);

        employeeBook.printEmployeesForDepartment(1);
    }
}
