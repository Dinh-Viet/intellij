package Company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyManagement {

    private static List<Person> list = new ArrayList<Person>();
    private static Person person;
    public void runMainMenu() {

        Scanner scanner = new Scanner(System.in);

        mainMenuLoop: while (true) {
            System.out.println();
            System.out.println("1. Tạo nhân sự mới ");
            System.out.println("2. Hiển thị tất cả nhân sự");
            System.out.println("3. Tìm kiếm nhân sự theo ID");
            System.out.println("4. Cập nht nhân sự");
            System.out.println("5. Xem lương của nhân sự");
            System.out.println("6. Cập nhật lương cho nhân sự");
            System.out.println("7. Thoát");
            System.out.print("Hãy nhập lựa chọn của bạn (1 - 7): ");
            int selectedMenu = Integer.parseInt(scanner.nextLine());
            switch (selectedMenu) {
                case 1 -> {
                    createNewPerson();
                }
                case 2 -> {
                    displayAllPeople();
                }
                case 3 -> {
                    findPerson();
                }
                case 4 -> {
                    updatePerson();
                }
                case 5 -> {
                    checkSalary();
                }
                case 6 -> {
                    updateSalary();
                }
                case 7 -> {
                    break mainMenuLoop;
                }
            }
        }
    }

    public void createNewPerson() {
        Scanner scanner = new Scanner(System.in);
        int selectedMenu = 0;
        createNewPersonLoop: while (true) {
            System.out.println();
            System.out.println("===== Tạo nhân sự mới =====");
            System.out.println("1. Giám đốc");
            System.out.println("2. Trưởng phòng");
            System.out.println("3. Nhân viên");
            System.out.print("Bạn muốn tạo nhân sự nào (1 - 3),hoặc nhấn A để quay lại: ");
            try {
                selectedMenu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break createNewPersonLoop;
            }
            switch (selectedMenu) {
                case 1 -> {
                    person = new Director();
                }
                case 2 -> {
                    person = new Manager();
                }
                case 3 -> {
                    person = new Staff();
                }
            }
            person.inputData();
            list.add(person);
        }

    }

    public void displayAllPeople() {
        System.out.println("Đang hiển thị " + list.size() + " nhân sự..........");
        for (Person person : list) {
            person.displayData();
        }
    }

    public void findPerson() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Nhập ID của nhân sự bạn muốn tìm kiếm (hoặc nhấn A để quay lại): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPersonById(id);
            if (result != null) {
                System.out.print("Tìm thấy 1 kết quả: ");
                result.displayData();
            } else {
                System.out.println("Không tìm thấy kết quả nào.");
            }
        }

    }

    public Person findPersonById(int id) {
        for (Person person : list) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Nhập ID của nhân sự bạn muốn cập nhật (hoặc nhấn A để quay lại): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPersonById(id);
            if (result != null) {
                System.out.print("Tìm thấy 1 kết quả: ");
                result.displayData();
                result.updatePerson();
            } else {
                System.out.println("Không tìm thấy kết quả nào.");
            }
        }
    }

    public void checkSalary() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Nhập ID của nhân sự bạn muốn xem lương (hoặc nhấn A để quay lại): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPersonById(id);
            if (result != null) {
                System.out.print("Tìm thấy 1 kết quả: ");
                result.displayData();
            } else {
                System.out.println("Không tìm thấy kết quả nào.");
            }
        }
    }

    public void updateSalary() {
        Scanner scanner = new Scanner(System.in);
        findPersonLoop: while (true) {
            System.out.println();
            int id;
            System.out.print("Nhập ID của nhân sự bạn muốn cập nhật lương  (hoặc nhấn A để quay lại): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                break findPersonLoop;
            }
            Person result = findPersonById(id);
            if (result != null) {
                System.out.print("Tìm thấy 1 kết quả:");
                result.displayData();
                result.updateSalary();
            } else {
                System.out.println("Không tìm thấy kết quả nào.");
            }
        }
    }
}
