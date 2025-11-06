import java.util.Arrays;

public class EmployeeBook {
    private final Employee [] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }

    }
    public double getAverageSalary() {
        int sum = 0;
        int count = 0;

        for (Employee e : employees) {
            if (e != null) {
                sum += e.getSalary();
                count++;
            } else
                break;
        }
        if (count == 0) {
            return 0.0;
        } else {
            return (double) sum / count;
        }
    }
    public void printTaxes(String type) {
        for (Employee e : employees) {
            if (e == null) {
                break;
            }
            double tax = 0;
            switch (type.toUpperCase()) {
                case "PROPORTIONAL":
                    tax = e.getSalary() * 0.13;
                break;
                case "PROGRESSIVE":
                    if (e.getSalary() > 350000) {
                        tax = e.getSalary() * 0.21;
                    } else if (e.getSalary() > 150000) {
                        tax = e.getSalary() * 0.17;
                    } else {
                        tax = e.getSalary() * 0.13;
                    }
                break;
                default:
                    System.out.println("Неизвестный тип налога");
                    return;
            }
            System.out.println(e.getSurname() + " " + e.getName() + " налог:  " + tax);
        }
    }

    public void indexDepartmentSalary(int department, double percent) {
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }
            if (e.getDepartment() == department) {
                int oldSalary = e.getSalary();
                int newSalary = (int) (oldSalary * (1 + percent/100));
                if (newSalary < 0) {
                    newSalary = 0;
                }
                e.setSalary(newSalary);
            }
        }
    }

    public void findFirstByDeptSalary(int department, int salaryLimit) {
        for (int i = 0; i <= employees.length; i++) {
            Employee e = employees[i];
            if (e == null) {
                break;
            }
            if (e.getDepartment() == department && e.getSalary() > salaryLimit) {
                System.out.println(" Сотрудник № " + ( i + 1 ) + " : ");
                e.printShortInfo();
                break;
            }
        }
    }
    public void findFirstWithLowSalary(int employeeNumber, int warg) {
        int count = 0;
        int i = 0;
        while (i < employees.length && count < employeeNumber) {
        Employee e = employees[i];
        if (e == null) {
            break;
        }
        if (e.getSalary() < warg) {
            count++;
            e.printShortInfo();
        }
        i++;
        }
    }
    public boolean contains(Employee employee) {
        for (Employee e : employees) {
            if (e != null && e.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        for ( int i = 0; i < employees.length; i++ ) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }
    public Employee getById(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
