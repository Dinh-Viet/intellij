package Company;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public abstract class Person {

    private static int Number = 0;
    protected int id;
    protected String name;
    protected double bonuss;
    protected double salary;

    public Person() {
        this.id = ++Number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBonuss() {
        return bonuss;
    }

    public double getSalary() {
        return salary;
    }

    public double getTotalSalary() {
        return bonuss * salary + salary;
    }

    public abstract void inputData();
    public abstract void displayData();
    public abstract void updatePerson();

    public void updateSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cập nhật lương mới ($): ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.printf("Đã cập nhật: Lương cơ bản mới = $%.2f%n", salary);
    }
}

class Director extends Person{
    private String role;

    public Director(){
        super();
        bonuss = 0.5;
    }
    public String getRole(){

        return role;
    }
    @Override
    public void inputData() {
        System.out.print("Tạo vị trí giám đốc: ");
        Scanner scanner= new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập lương cơ bản ($): ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vị trí, bộ phận: ");
        role = scanner.nextLine();
        System.out.print("Đã tạo thành công. ");
        displayData();
    }

    @Override
    public void displayData() {
        System.out.printf("Giám đốc [id = %d, tên = %s," +
                        " chức vụ = %s, lương cơ bản = $%.2f," +
                        " mức thươởng = %.2f, tổng lương = $%.2f]%n", getId(), getName(),getRole(),
                getSalary(), getBonuss(), getTotalSalary());
    }

    @Override
    public void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cập nhật tên: ");
        name = scanner.nextLine();
        System.out.print("Cập nhật vị trí,bộ phận: ");
        role = scanner.nextLine();
        System.out.print("Đã cập nhật thành công. ");
        displayData();
    }
}

class Manager extends Person{
    private String part;

    public Manager(){
        super();
        bonuss = 0.3;
    }
    public String getPart(){

        return part;
    }

    @Override
    public void inputData() {
        System.out.print("Đang khởi tạo trưởng phòng: ");
        Scanner scanner= new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập lương cơ bản ($): ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vị trí, bộ phận: ");
        part = scanner.nextLine();
        System.out.print("Đã tạo thành công. ");
        displayData();

    }

    @Override
    public void displayData() {
        System.out.printf("Trưởng phòng [id = %d, tên = %s,Bộ phận = %s, " +
                        "Lương cơ bản = $%.2f, mức thưởng = %.2f, tổng lương = $%.2f]%n" ,
                         getId(), getName(),getPart(), getSalary(),
                         getBonuss(),getTotalSalary());
    }

    @Override
    public void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cập nhật tên: ");
        name = scanner.nextLine();
        System.out.print("Cập nhật bộ phận: ");
        part = scanner.nextLine();
        System.out.print("Đã cập nhật thành công.");
        displayData();
    }
}
class Staff extends Person{
    private String skill;

    public Staff() {
        super();
        bonuss = 0.1;
    }
    public String getSkill(){
        return skill;
    }

    @Override
    public void inputData() {
        System.out.print("Đang khởi tạo nhân viên: ");
        Scanner scanner= new Scanner(System.in);
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập lương cơ bản ($): ");
        salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập vị trí: ");
        skill = scanner.nextLine();
        System.out.print("Đã tạo thành công.");
        displayData();
    }

    @Override
    public void displayData() {
        System.out.printf("Nhân viên [id = %d, tên = %s," +
                        " Lương cơ bản = $%.2f, mức thưởng = %.2f, " +
                        "Tổng lương = $%.2f]%n", getId(), getName(), getSalary(),
                getBonuss(), getSkill(),getTotalSalary());
    }

    @Override
    public void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cập nhật tên : ");
        name = scanner.nextLine();
        System.out.print("Cập nhật vị trí: ");
        skill = scanner.nextLine();
        System.out.print("Đã tạo thành công.");
        displayData();
    }
}