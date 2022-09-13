import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getName() + " " + employee.getSurname() + " " + employee.getPatronymicName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String name, String surname, String patronymicName, double salary, int department) {
        addEmployee(new Employee(name, surname, patronymicName, salary, department));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getId() == id) {
                employees.remove(entry.getKey());
                break;
            }
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newDepartment);
        }
    }

    public void printEmployeesByDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники из отдела " + department + " :");
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymicName());
                }
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(double bound) {
        System.out.println("Сотрудник с зарплатой менее чем " + bound + " :");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, зарплата: %.2f%n",
                        employee.getId(),
                        employee.getSurname(),
                        employee.getName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void printEmployeesWithSalaryGreaterOrEqualThen(double bound) {
        System.out.println("Сотрудник с зарплатой большей или равной чем " + bound + " :");
        for (Employee employee : employees.values()) {
            if (employee.getSalary() < bound) {
                System.out.printf(
                        "id: %d, ФИО: %s %s %s, зарплата: %.2f%n",
                        employee.getId(),
                        employee.getSurname(),
                        employee.getName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                );
            }
        }
    }

    public void indexSalaries(double index) {
        for (Employee employee : employees.values()) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
        }
    }

    public void indexSalariesForDepartment(double index, int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getDepartment() * index / 100);
            }
        }

    }

    public double averageSalary() {
        return totalSalaries() / employees.size();
    }

    public double averageSalaryForDepartment(int department) {
        double totalSalaryForDepartment = 0;
        int count = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                totalSalaryForDepartment = employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : totalSalaryForDepartment / count;
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String minKey = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minKey = entry.getKey();
            }
        }
        if (minKey != null) {
            return employees.get(minKey);
        } else {
            return null;
        }
    }

    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        String keyMin = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                keyMin = entry.getKey();
            }
        }
        if (keyMin != null) {
            return employees.get(keyMin);
        } else {
            return null;
        }
    }

    public Employee findEmployeeMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String keyMax = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getSalary() < maxSalary) {
                maxSalary = employee.getSalary();
                keyMax = entry.getKey();
            }
        }
        if (keyMax != null) {
            return employees.get(keyMax);
        } else {
            return null;
        }
    }

    public double totalSalariesForDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            sum = employee.getSalary();
        }
        return sum;
    }

    public void printFullNameEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymicName());
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void printEmployeesForDepartment(int department) {
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == department) {
                System.out.printf("id: %d, ФИО: %s %s %s, зарплата:  %.2f%n",
                        employee.getId(),
                        employee.getSurname(),
                        employee.getName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                );
            }
        }

    }
}


//    public Employee[] getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Employee[] employees) {
//        this.employees = employees;
//    }
//
//    public Employee[] getDepartmentArr() {
//        return departmentArr;
//    }
//
//    public void setDepartmentArr(Employee[] departmentArr) {
//        this.departmentArr = departmentArr;
//    }
//
//    public static void addEmployee() {
//        /** Инициализируем массив Employees данными сотрудников */
//        employees[0] = new Employee("Ivan", "Ivanovich",
//                "Ivanov", 1, 58_236);
//        employees[1] = new Employee("Petr", "Petrovich",
//                "Petrov", 2, 45_622);
//        employees[2] = new Employee("John", "Johnovich",
//                "Silver", 3, 74_600);
//        employees[3] = new Employee("Igor", "Igorevich",
//                "Smirnov", 1, 35_800);
//        employees[4] = new Employee("Andrey", "Andreevich",
//                "Andreev", 5, 22_200);
//        employees[5] = new Employee("Pavel", "Pavlovich",
//                "Pavlov", 4, 38_648);
//        employees[6] = new Employee("Mark", "Markovich",
//                "Markov", 4, 38_648);
//        employees[7] = null;
//        employees[8] = new Employee("Aleksandar", "Ivanovich",
//                "Ivanov", 4, 38_648);
//        employees[9] = new Employee("Uliya", "Ivanovna",
//                "Pavlova", 4, 38_648);
//    }
//
//
//    public static void recordEmployeesInDepartment(int department) {
//        /** создаем список сотрудников отдела*/
//        for (int i = 0; i < employees.length; i++) {
//            if (checkNull(employees[i])) {
//                if (employees[i].getDepartmentNumber() == department) {
//                    departmentArr[i] = employees[i];
//                }
//            }
//        }
//    }
//
//    static void printEmployees(Employee[] employ) {
//        /**  Выводим данные сотрудников в консоль */
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                System.out.println(employ[i].toString());
//            }
//        }
//        splitIntoBlocks();
//    }
//
//    private double calculateAllMonthlySalary(Employee[] employ) {
//        /** Считаем и возвращаем затраты  на зарплату за месяц */
//        double salaryCounter = 0;
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                salaryCounter += employ[i].getEmployeeSalary();
//            }
//        }
//        return salaryCounter;
//    }
//
//    private String searchMinimumWage(Employee[] employ) {
//        /** Находим и возвращаем сотрудника с минимальной зарплатой */
//        double minSalary = employ[0].getEmployeeSalary();
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                if (employ[i].getEmployeeSalary() < minSalary) {
//                    minSalary = employ[i].getEmployeeSalary();
//                }
//            }
//        }
//        String minSalaryEmployee = "";
//        for (int j = 0; j < employ.length; j++) {
//            if (checkNull(employ[j])) {
//                if (employ[j].getEmployeeSalary() == minSalary) {
//                    minSalaryEmployee = employ[j].toString();
//                }
//            }
//        }
//        return minSalaryEmployee;
//    }
//
//    private String searchMaximumWage(Employee[] employ) {
//        /** Находим и возвращаем сотрудника с максимальной зарплатой */
//        double maxSalary = employ[0].getEmployeeSalary();
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                if (maxSalary < employ[i].getEmployeeSalary()) {
//                    maxSalary = employ[i].getEmployeeSalary();
//                }
//            }
//        }
//        String maxSalaryEmployee = "";
//        for (int j = 0; j < employ.length; j++) {
//            if (checkNull(employ[j])) {
//                if (employ[j].getEmployeeSalary() == maxSalary) {
//                    maxSalaryEmployee = employ[j].toString();
//                }
//            }
//        }
//        return maxSalaryEmployee;
//
//    }
//
//    private double calculateЕheAverageSalary(Employee[] employ) {
//        /** Находим и возвращаем среднюю зарплату  */
//        double salaryCounter = 0;
//        int counterEmployee = 0;
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                salaryCounter += employ[i].getEmployeeSalary();
//                counterEmployee++;
//            }
//        }
//        return salaryCounter / counterEmployee;
//    }
//
//    private void printEmployeesNames(Employee[] employ) {
//        /** Выводим ФИО сотрудников в консоль */
//        System.out.println("F.I.O all employees: ");
//        for (Employee employee : employ) {
//            if (checkNull(employee)) {
//                System.out.println("Employee: " + employee.getEmployeeName() + " " +
//                        employee.getEmployeePatronymic() + "  " + employee.getEmployeeSurname());
//            }
//        }
//        splitIntoBlocks();
//    }
//
//    private void indexingTheSalary(int index, Employee[] employ) {
//        /** Индексируем зарплату сотрудников */
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                employees[i].setEmployeeSalary(employ[i].getEmployeeSalary() + (employ[i].getEmployeeSalary()
//                        / 100) * index);
//            }
//        }
//    }
//
//
//    private void printEmployeesDepartment() {
//        /** Выводим список сотрудников отдела без номера отдела*/
//        System.out.println("List employees department number " + department);
//        for (int i = 0; i < departmentArr.length; i++) {
//            if (checkNull(departmentArr[i])) {
//                System.out.println(departmentArr[i].getEmployeeName() + " " + departmentArr[i].getEmployeePatronymic() + " "
//                        + departmentArr[i].getEmployeeSurname() + " salary: " + departmentArr[i].getEmployeeSalary() + " id: " +
//                        departmentArr[i].getEmployeeId());
//            }
//        }
//    }
//
//    private void getSalaryLess(Employee[] employ, double accountingSalary) {
//        /** Выводим список сотрудников, чьи зарплаты меньше указанного числа*/
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                if (employ[i].getEmployeeSalary() < accountingSalary) {
//                    System.out.println(employ[i].toString());
//                }
//            }
//        }
//    }
//
//    private void getSalaryMore(Employee[] employ, double accountingSalary) {
//        /** Выводим список сотрудников, чьи зарплаты больше или равны указанному числу */
//        for (int i = 0; i < employ.length; i++) {
//            if (checkNull(employ[i])) {
//                if (employ[i].getEmployeeSalary() >= accountingSalary) {
//                    System.out.println(employ[i].toString());
//                }
//            }
//        }
//    }
//
//    private boolean checkNull(Employee employee) {
//        /** проверяем полученные данные на отсутствие Null */
//        return employee != null;
//    }
//
//    private void splitIntoBlocks() {
//        /** Вставляем разделитель */
//        System.out.println("==================================================");
//        System.out.println("==================================================");
//    }

