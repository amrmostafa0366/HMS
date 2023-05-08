package HMS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        ArrayList<Room> rooms = new ArrayList<>();
        Guest guest = new Guest();
        Room room = new Room();
        Employee employee = new Employee();

        hotel.getEmployees().add(new Employee("mohamed", 26, "Male", "1", Job.Management, 100000));
        hotel.getEmployees().add(new Employee("amr", 23, "Male", "2", Job.Management, 1000000));
        hotel.getEmployees().add(new Employee("ahmed", 18, "Male", "3", Job.Management, 1000000));
        hotel.getEmployees().add(new Employee("Youssef", 30, "Male", "4", Job.Bellman, 5000));
        hotel.getEmployees().add(new Employee("Fatma", 25, "Female", "5", Job.Receptionist, 7000));
        hotel.getEmployees().add(new Employee("Ali", 35, "Male", "6", Job.Chief, 6000));
        hotel.getEmployees().add(new Employee("Sara", 22, "Female", "7", Job.Laundry, 9000));


        hotel.getGuests().add(new Guest("amr", 23, "male", "1", 0));
        hotel.getGuests().add(new Guest("mohamed", 26, "male", "2", 0));
        hotel.getGuests().add(new Guest("ahmed", 18, "male", "3", 0));
        hotel.getGuests().add(new Guest("Sarah", 30, "female", "123", 3));
        hotel.getGuests().add(new Guest("John", 42, "male", "456", 2));
        hotel.getGuests().add(new Guest("Lisa", 25, "female", "789", 1));

        hotel.getRooms().add(new Room(1, RoomType.Single, 1000, true, true, null));
        hotel.getRooms().add(new Room(2, RoomType.Double, 2000, true, true, null));
        hotel.getRooms().add(new Room(3, RoomType.Suite, 3000, true, true, null));
        hotel.getRooms().add(new Room(4, RoomType.Single, 1000, true, true, null));
        hotel.getRooms().add(new Room(5, RoomType.Double, 2000, true, true, null));
        hotel.getRooms().add(new Room(6, RoomType.Suite, 3000, true, true, null));
        hotel.getRooms().add(new Room(7, RoomType.Single, 1000, true, true, null));
        hotel.getRooms().add(new Room(8, RoomType.Double, 2000, true, true, null));
        hotel.getRooms().add(new Room(9, RoomType.Suite, 3000, true, true, null));

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 100) {
            System.out.println("1.Admin      2.User");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (new Auth().login()) {
                        System.out.println("Admin Menu");
                    }
                    break;
                case 2: while(choice !=101){
                    System.out.println("1.Guest   2.Room   3.Employee   101.Back");
                    choice = scanner.nextInt();
                    switch (choice){
                        case 1:  while (choice != 102) {
                            System.out.println("1.Exist      2.New Comer      102.Back");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    while (choice != 103) {
                                        System.out.println("1.Search    2.Display Guests   103.back");
                                        choice = scanner.nextInt();

                                        switch (choice) {
                                            case 1:
                                                scanner.nextLine();
                                                System.out.print("Enter Guest Name or SSN : ");
                                                    guest = hotel.getGuest().getGuest(hotel.getGuests(), scanner.nextLine());
                                                    if(guest!=null) {
                                                        System.out.println(guest.toString());

                                                        System.out.print("Select Guest? 1.Yes 2.No : ");
                                                        choice = scanner.nextInt();
                                                        if (choice == 1) {
                                                            guestActions(hotel, guest, scanner);
                                                        }
                                                    }
                                                break;
                                            case 2: guest = hotel.getGuest().selectGuest(hotel.getGuests());
                                                if (guest != null) {
                                                    guestActions(hotel,guest,scanner);
                                                } break;

                                        }

                                    }break;
                                case 2: guest.addGuest(hotel.getGuests());
                                    guest = hotel.getGuests().get(hotel.getGuests().size()-1);
                                    // hotel.getGuests().add(guest);
                                    guestActions(hotel,guest,scanner);
                                    break;
                            }
                        }break;
                        case 2: while(choice !=104){
                            System.out.println("1.Search   2.Display   104.back");
                            choice = scanner.nextInt();
                            switch (choice){
                                case 1: System.out.println("Enter room number: ");
                                        int roomNumber = scanner.nextInt();
                                        room =hotel.getRoom().getRoom(hotel.getRooms(),roomNumber);
                                        if(room != null){
                                            System.out.println(room.toString());
                                            System.out.println("choices...");
                                        } break;
                                case 2: while (choice != 105){
                                    System.out.println("1.Display All  2.Display Occupied  3.Display Empty  105.Back");
                                    choice = scanner.nextInt();
                                            switch (choice){
                                                case 1: hotel.getRooms();
                                                        room = hotel.getRoom().selectRoom(hotel.getRooms());
                                                        roomActions(hotel,room); break;
                                                case 2: room = hotel.getRoom().selectRoom(hotel.getRoom().getOccupiedRooms(hotel.getRooms()));
                                                        roomActions(hotel,room); break;
                                                case 3: room = hotel.getRoom().selectRoom(hotel.getRoom().getEmptyRooms(hotel.getRooms()));
                                                         roomActions(hotel,room); break;
                                            }
                                            System.out.println("");
                                        } break;
                            }
                        }break;
                        case 3: while(choice !=105){
                            System.out.println("1.Search   2.Display   105.Back");
                            choice = scanner.nextInt();
                            switch (choice){
                                case 1:System.out.print("Enter Employee Name or SSN: ");
                                        scanner.nextLine();
                                      String search = scanner.nextLine();
                                      employee = hotel.getEmployee().getEmployee(hotel.getEmployees(),search);
                                      if(employee != null){
                                          System.out.println(employee.toString());
                                      }break;
                                case 2:while(choice !=106){
                                    System.out.println("1.Display All   2.Display Department   106.Back");
                                    choice = scanner.nextInt();
                                    switch (choice){
                                        case 1: hotel.getEmployee().display(hotel.getEmployees());
                                            System.out.println();
                                            break;
                                        case 2: while(choice != 107){
                                            System.out.println("1.Management  2.Accountant  3.Receptionist  4.Security\n5.HouseKeeper  6.Bellman  7.Chief  8.Laundry  107.Back");
                                            choice = scanner.nextInt();
                                            displayEmployeesByDepartment(hotel,choice);
                                            System.out.println();
                                        }break;
                                    }
                                } break;
                            }
                        }break;
                    }
                }break;

            }
        }
    }

    private static void displayEmployeesByDepartment(Hotel hotel, int choice) {
        switch(choice){
        case 1: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Management");break;
        case 2: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Accountant");break;
        case 3: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Receptionist");break;
        case 4: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Security");break;
        case 5: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"HouseKeeper");break;
        case 6: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Bellman");break;
        case 7: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Chief");break;
        case 8: hotel.getEmployee().displayDepartment(hotel.getEmployees(),"Laundry");break;
        }
        }

    private static void guestActions(Hotel hotel, Guest guest, Scanner scanner) {

        int choice = 0;
        while (choice != 108) {
            System.out.println("1.CheckIn  2.CheckOut  3.Add Bill  4.Display Bills  108.Back");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:guest.checkIn(guest, hotel.getRoom().selectRoom(hotel.getRoom().getEmptyRooms(hotel.getRooms()))); break;
                case 2:hotel.getGuest().checkOut(guest);break;
                case 3:while (choice != 1031) {
                        scanner.nextLine();
                        guest.getBills().add(hotel.getBill().addBill());
                        System.out.println("Add Another Bill? 1.yes  2.no");
                        choice = scanner.nextInt();
                        if (choice != 1) {
                            choice = 1031;
                        }
                    }break;
                case 4: if(guest.getBills() != null)
                    System.out.println(guest.getBills().toString());break;
            }
        }
    }

    private static void roomActions(Hotel hotel, Room room){
        if(room != null) {
            System.out.println(room.toString());
            System.out.println("Selected Room Choices");
        }
    }


}