public class Employee {
    private String name;
    private int department;
    private int wage;
    static int count;
    private int id;


    public Employee (String name, int department, int wage) {
        this.name = name;
        this.department = department;
        this.wage = wage;
        count++;
        this.id = count;
    }

    public String getName() {
        return name;
    }
    public int getDepartment() {
        return department;
    }
    public int getWage() {
        return wage;
    }
    public int getId() {
        return id;
    }


    public void setDepartment(int department) {
        this.department = department;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", wage=" + wage +
                ", id=" + id +
                '}';
    }
    public String getDep() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", wage=" + wage +
                ", id=" + id +
                '}';
    }
}
