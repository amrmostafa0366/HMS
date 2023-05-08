package HMS;

import java.util.Scanner;

public class Program {
    public static void main(String [] args){

        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        Guest g = new Guest();
        Room r = new Room();
        Employee e = new Employee();
        Bill b = new Bill();

       // hotel.getEmployees().add(new Employee("mohamed",26,"Male","0106777",Job.Manager,100000));
        //hotel.getEmployees().add(new Employee("amr",23,"Male","0100211",Job.CoManager,90000));
        hotel.getEmployees().add(new Employee("ahmed",18,"Male","011484",Job.Security,80000));

        hotel.getGuests().add(new Guest("amr",23,"male","1",5));
        hotel.getGuests().add(new Guest("mohamed",26,"male","2",10));
        hotel.getGuests().add(new Guest("ahmed",18,"male","3",14));

        hotel.getRooms().add(new Room(1,RoomType.Single,1000,true,true,null));
        hotel.getRooms().add(new Room(2,RoomType.Double,2000,true,true,null));
        hotel.getRooms().add(new Room(3,RoomType.Suite,3000,true,true,null));


        while(choice != 666) {
            //main menu
            System.out.println("Choices\n1.Guests\n2.Rooms\n3.Employees\n4.HotelManager");
            choice = scanner.nextInt();
                switch (choice) {
                    //Guest Menu
                    case 1: while (choice != 666) {
                        System.out.println("Guest Menu\n1.Add Guest  2.Read Guest  3.Update Guest\n4.Delete Guest  5.Display Guests  6.Back to Main Menu");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:g.addGuest(hotel.getGuests());break;
                            case 2:scanner.nextLine();
                                   System.out.println(g.getGuest(hotel.getGuests(), scanner.nextLine()));break;
                            case 3: g.updateGuest(hotel.getGuests(), scanner.nextInt() - 1);break;
                            case 4: g.deleteGuest(hotel.getGuests(), scanner.nextInt() - 1); break;
                            case 5: g.display(hotel.getGuests());break;
                            case 6:return;

                        }
                    } break;
                    //Room Menu
                    case 2: while (choice != 666) {
                        System.out.println("Room Menu\n1.Add Room  2.Read Room  3.Update Room\n4.Delete Room  5.Display Rooms  6.Back to Main Menu");
                        choice = scanner.nextInt();
                        switch (choice){
                            case 1: r.addRoom(hotel.getRooms()); break;
                            case 2: System.out.println("Enter Room Number: ");
                                    r.getRoom(hotel.getRooms(),scanner.nextInt()); break;
                            case 3: r.updateRoom(hotel.getRooms(),scanner.nextInt()-1); break;
                            case 4: r.deleteRoom(hotel.getRooms(),scanner.nextInt()-1); break;
                            case 5: r.display(hotel.getRooms()); break;
                        }
                    } break;
                    //Employee Menu
                    case 3: while (choice != 666){
                        System.out.println("Employee Menu\n1.Add Employee  2.Read Employee  3.Update Employee\n4.Delete Employee  5.Display Employees  6.Back to Main Menu");
                        choice = scanner.nextInt();
                        switch (choice){
                            case 1: e.addEmployee(hotel.getEmployees()); break;
                            case 2: System.out.println("SSN: ");
                                    Employee employee = e.getEmployee(hotel.getEmployees(), scanner.next());
                                    if(employee!=null){
                                        System.out.println(employee.toString());
                                    } break;
                            case 3: e.updateEmployee(hotel.getEmployees(),scanner.nextInt()-1); break;
                            case 4: e.deleteEmployee(hotel.getEmployees(),scanner.nextInt()-1); break;
                            case 5: e.display(hotel.getEmployees()); break;
                        }
                    } break;
                    //HotelManager Menu
                    case 4: while (choice != 666){
                        System.out.println("Hotel Manager\n1.CheckIn  2.CheckOut  3.Display Guests\n4.Display Rooms  5.Add Bills  6.Display Bills");
                        choice = scanner.nextInt();
                        switch (choice){
                            case 1: g.checkIn(g.selectGuest(hotel.getGuests()),r.selectRoom(hotel.getRooms())); break;
                            case 2: g.checkOut(g.selectGuest(hotel.getGuests())); break;
                            case 3: g.display(hotel.getGuests()); break;
                            case 4: r.display(hotel.getRooms()); break;
                            case 5: b.addBill(g.selectGuest(hotel.getGuests())); break;
                            case 6: b.display(g.selectGuest(hotel.getGuests()).getBills()); break;
                    }
                }
            }
        }
    }
}
