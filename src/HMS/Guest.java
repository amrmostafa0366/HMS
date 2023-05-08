package HMS;

import java.util.ArrayList;
import java.util.Scanner;

public class Guest extends Person{
    private int nights;
    private Room room;
    private ArrayList<Bill> bills;

    public Guest(String name, int age, String gender, String ssn, int nights) {
        super(name, age, gender, ssn);
        this.nights = nights;
        this.room = null;
        this.bills = new ArrayList<Bill>();
    }

    public Guest() {}

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    private Guest createGuest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter guest name:");
        String name = scanner.nextLine();

        System.out.println("Enter guest age:");
        int age = scanner.nextInt();

        System.out.println("Enter guest gender:");
        String gender = scanner.next();

        System.out.println("Enter guest SSN:");
        String ssn = scanner.next();

        System.out.println("Enter Number of Nights:");
        int nights = scanner.nextInt();

        return new Guest(name, age, gender, ssn,nights);
    }
    public void addGuest(ArrayList<Guest> guests){
        guests.add(createGuest());
    }
    public Guest getGuest(ArrayList<Guest> guests,String txt){
        for(Guest guest: guests){
            if(guest.getSsn().equals(txt) || guest.getName().equals(txt)){
                return guest;
            }
        }
        return null;
    }
    public void updateGuest(ArrayList<Guest> guests,int index){
        guests.set(index,createGuest());
    }
    public void deleteGuest(ArrayList<Guest> guests , int index){
        guests.remove(index);
    }
    public void display(ArrayList<Guest> guests){
        int i = 1;
        for(Guest guest: guests){
            System.out.println(i+++"." + guest.toString());
        }
    }

    ////////////////Select guest,checkIn,CheckOut////////////////
    public Guest selectGuest(ArrayList<Guest> guests){
        Scanner scanner = new Scanner(System.in);
        display(guests);
        System.out.print("Select Guest: ");
        int index = scanner.nextInt() - 1;
        if(index<0 || index>= guests.size()){
            System.out.println("Invalid Selection");
        }
        else{
            return guests.get(index);
        }
        return null;
    }

    public void checkIn(Guest guest, Room room) {
        if (guest != null && room != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of nights: ");
            setNights(scanner.nextInt());
            guest.setRoom(room);
            room.setGuest(guest);
            room.setEmpty(false);

            if (guest.getBills() == null) { // initialize bills if null
                guest.setBills(new ArrayList<Bill>());
            }
            guest.getBills().add(new Bill(getNights() * room.getNightCost(), "Accommodation"));
        }
    }






    public void checkOut(Guest guest){
        if(guest != null) {
            if(guest.getRoom()!=null) {
                room = guest.getRoom();
                guest.setRoom(null);
                room.setGuest(null);
                room.setEmpty(true);
                setNights(0);
            }else{
                System.out.println("This Guest has no room...");
            }
        }
    }



    ///////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        if(room != null)
        return super.toString() +
                "Guest{" +
                "nights=" + nights +
                ", room=" + room.getRoomNumber() +
                '}';
        else{
            return super.toString() +
                    "Guest{" +
                    "nights=" + nights +
                    ", room= Null" +
                    '}';
        }

    }
}
