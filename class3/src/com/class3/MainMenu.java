package com.class3;

public class MainMenu {
    public static void main(String[] args) {
        PersonManagement management=new PersonManagement(); Person viet = new Person(1,"Dinh Doanh Viet","vietdinh1172004@gmail.com","Tuyen Quang","0353241999");
        Person nghia = new Person(2,"Trong Nghia","nghia@gmail.com","Ha Noi","0353241999");
        Person nghiaa = new Person(3,"Trong Nghia","nghia@gmail.com","Ha Noi","0353241999");
        Person nghiaaa = new Person(4,"Trong Nghia","nghia@gmail.com","Ha Noi","0353241999");
        management.personMap.put(1,viet);
        management.personMap.put(2,nghia);
        management.personMap.put(3,nghiaa);
        management.personMap.put(4,nghiaaa);
        System.out.println("=".repeat(110));
        System.out.printf("| %-10s | %-25s | %-25s | %-20s | %-20s\n", "ID", "NAME", "EMAIL", "ADDDRESS", "PHONE");
        System.out.println("=".repeat(110));
        for(Integer key : management.personMap.keySet()){
            Person person = management.personMap.get(key);
            System.out.printf("| %-10s | %-25s | %-25s | %-20s | %-20s\n", person.id, person.name, person.email, person.address, person.phone);
            System.out.println("-".repeat(110));
        }
    }
}
