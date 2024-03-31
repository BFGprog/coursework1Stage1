public class Main {
    private static Employee[] employee = new Employee[10];

    public static void main(String[] args) {
        employee[0] = new Employee("Иванов Иван0", 1, 35_000);
        employee[1] = new Employee("Иванов Иван1", 2, 36_000);
        employee[2] = new Employee("Иванов Иван2", 3, 37_000);
        employee[3] = new Employee("Сидоров Иван1", 3, 38_000);
        employee[4] = new Employee("Сидоров Иван2", 2, 39_000);
        employee[5] = new Employee("Сидоров Иван3", 4, 40_000);
        employee[6] = new Employee("Петров Иван1", 1, 40_000);
        employee[7] = new Employee("Петров Иван2", 2, 41_000);
        employee[8] = new Employee("Петров Иван3", 5, 42_000);
        employee[9] = new Employee("Петров Иван4", 5, 45_000);

        // Базовая сложность
        // Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString));
        printAllEmployee();
        // Посчитать сумму затрат на ЗП в месяц;
        System.out.println(isWageMonth());
        // Найти сотрудника с минимальной ЗП;
        System.out.println(isWageMin());
        // Найти сотрудника с максимальной ЗП;
        System.out.println(isWageMax());
        // Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b);
        System.out.println(isWageMedium());
        // Распечатать ФИО всех сотрудников (метод ничего???).
        printAllName();

        // Повышенная сложность
        // Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
        performWageIndexation(0);
        // Получить в качестве параметра номер отдела (1-5) и найти (всего 6 методов):
        // Сотрудника с минимальной зп;
        isWageMinDepartment(2);
        // Сотрудника с максимальной зп;
        isWageMaxDepartment(3);
        // Сумму затрат на зп по отделу;
        isWageMonthDepartment(1);
        // Среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
        isWageMediumDepartment(1);
        // Проиндексировать зарплату всех сотрудников отдела на процент, который
        // приходит в качестве параметра;
        performWageIndexationDepartment(10, 5);
        // Напечатать всех сотрудников отдела (все данные, кроме отдела).
        printAllEmployeeDepartment(1);
        // Получить в качестве параметра число и вывести:
        // Всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль);
        printWageLess(40000);
        // Всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль).
        printWageMore(40_500);

    }

    private static void printAllEmployee() {
        System.out.println("Cписок всех сотрудников: ");
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
        System.out.println();
    }
    public static int isWageMonth() {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            sum = sum + employee[i].getWage();
        }
        return sum;
    }
    public static String isWageMin() {
        int wageMin = employee[0].getWage();
        String name = "";
        for (int i = 0; i < employee.length; i++) {
            if (wageMin > employee[i].getWage()) {
                wageMin = employee[i].getWage();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (wageMin == employee[i].getWage()) {
                name = employee[i].getName() + " " + employee[i].getWage();
            }
        }
        return name;
    }
    public static String isWageMax() {
        int wageMax = employee[0].getWage();
        String name = "";
        for (int i = 0; i < employee.length; i++) {
            if (wageMax < employee[i].getWage()) {
                wageMax = employee[i].getWage();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (wageMax == employee[i].getWage()) {
                name = employee[i].getName() + " " + employee[i].getWage();
            }
        }
        return name;
    }
    public static int isWageMedium() {
        int medium = 0;
        medium = isWageMonth() / Employee.count;
        return medium;
    }

    public static void printAllName(){
        System.out.println("Полный список: ");
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].getName());
        }
    }

    public static void performWageIndexation(double percent) {
        for (int i = 0; i < employee.length; i++) {
            employee[i].setWage(employee[i].getWage() * (int) (1 + percent / 100.0));
        }
    }
    public static String isWageMinDepartment(int dep) {
        int wageMin = -1;
        String name = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                wageMin = employee[i].getWage();
                if (wageMin > employee[i].getWage()) {
                    wageMin = employee[i].getWage();
                }
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (wageMin == employee[i].getWage()) {
                name = employee[i].getName() + " " + employee[i].getWage();
            }
        }
        return name;
    }
    public static String isWageMaxDepartment(int dep) {
        int wageMax = -1;
        String name = "";
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                wageMax = employee[0].getWage();
                if (wageMax < employee[i].getWage()) {
                    wageMax = employee[i].getWage();
                }
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (wageMax == employee[i].getWage()) {
                name = employee[i].getName() + " " + employee[i].getWage();
            }
        }
        return name;
    }
    public static int isWageMonthDepartment(int dep) {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                sum = sum + employee[i].getWage();
            }
        }
        return sum;
    }
    public static int isWageMediumDepartment(int dep) {
        int medium = 0;
        int count = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                count++;
            }
        }
        medium = isWageMonthDepartment(dep) / count;
        return medium;
    }
    public static void performWageIndexationDepartment(double percent, int dep) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                employee[i].setWage(employee[i].getWage() * (int) (1 + percent / 100.0));
            }
        }
    }
    public static void printAllEmployeeDepartment(int dep) {
        System.out.println("Cписок всех сотрудников отдела " + dep + ": ");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == dep) {
                System.out.println(employee[i].getDep());
            }
        }
    }

    public static void printWageLess(int wage) {
        System.out.println("Cписок всех сотрудников с зарплатой ниже - " + wage + ": ");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getWage() <= wage) {
                System.out.println(employee[i].getDep());
            }
        }
    }
    public static void printWageMore(int wage) {
        System.out.println("Cписок всех сотрудников с зарплатой больше - " + wage + ": ");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getWage() >= wage) {
                System.out.println(employee[i].getDep());
            }
        }
    }

}