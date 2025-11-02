//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        for (int i = 1; i <= 11; i++ ) {
            boolean added = employeeBook.addEmployee(new Employee(
                    "Имя " + i,
                    "Фамилия " + i,
                    "Отчество " + i,
                    (i % 5) + 1,
                    50 + i * 30
            ));
            System.out.println(" Добавление сотрудника " + i + ": " + added);
        }

        System.out.println( " Все сотрудники : ");
        employeeBook.printAllEmployees();

        System.out.println(" Средняя зарплата: " + employeeBook.getAverageSalary());

        System.out.println(" Налоги (PROPORTIONAL)");
        employeeBook.printTaxes("PROPORTIONAL");

        System.out.println(" Налоги (PROGRESSIVE)");
        employeeBook.printTaxes("PROGRESSIVE");

        System.out.println(" Индексация зарплаты 3 отдела на 10% : ");
        employeeBook.indexDepartmentSalary(3,10);
        employeeBook.printAllEmployees();

        System.out.println(" Первые сотрудник 3-его отдела с зарплатой выше 200: ");
        employeeBook.findFirstByDeptSalary(3, 200);
        employeeBook.printAllEmployees();

        System.out.println(" Первые 3 сотрудника с зарплатой ниже 250: ");
        employeeBook.findFirstWithLowSalary(2, 250);
        employeeBook.printAllEmployees();

        System.out.println(" Тест contains ");
        Employee testEmp = new Employee (" Сергеев ", "Сергей ", " Сергеевич ", 2 , 200);
        System.out.println(" Есть ли сотрудник с зарплатой 200: " + employeeBook.contains(testEmp));

        System.out.println(" Поиск по id ");
        Employee found = employeeBook.getById(2);
        if (found != null) {
            System.out.println(" Найден: " + found);
        } else {
            System.out.println(" Не найдено ");
        }
    }
}