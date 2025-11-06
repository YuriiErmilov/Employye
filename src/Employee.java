public class Employee {
    private static int counter = 1;

    private final int id;
    private String name;
    private String surname;
    private String middleName;
    private int department;
    private int salary;

    public Employee(String name, String surname, String middleName, int department, int salary) {
        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return salary;
    }

    @Override
    public String toString() {
        return "Emloyye{" +
                "id : " + id +
                ", ФИО : " + name + " " + surname + " " + middleName + '\'' +
                ", Отдел : " + department +
                ", Зарплата : " + salary +
                '}';
    }

    public void printShortInfo() {
        System.out.println(surname + " " + name + " - зарплата:  " + salary );
    }
}
