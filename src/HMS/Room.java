package HMS;

import java.util.ArrayList;
import java.util.Scanner;

enum RoomType{Single,Double,Suite}
public class Room {
    //private RoomNumber roomNumber;
    private int roomNumber;
    private RoomType roomType;
    private double nightCost;
    private boolean empty;
    private boolean clean;
    private Guest guest;

    public Room(int roomNumber, RoomType roomType,double nightCost, boolean empty, boolean clean, Guest guest) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightCost = nightCost;
        this.empty = empty;
        this.clean = clean;
        this.guest = guest;
    }

    public Room() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getNightCost() {
        return nightCost;
    }

    public void setNightCost(int nightCost) {
        this.nightCost = nightCost;
    }

    public boolean isEmpty() {
        return empty;
    }
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }
    public void setGuest(Guest guest){
        this.guest = guest;
    }
    public Guest getGuest(){
        return this.guest;
    }
    public void checkIn(Guest guest){
        setGuest(guest);
        setEmpty(false);
    }
    public void checkOut(){
        setGuest(null);
        setEmpty(true);
    }

    private Room createRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Room Number");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter Room Type");
        String roomType = scanner.next();
        RoomType type = RoomType.valueOf(roomType); // convert roomType input to enum
        System.out.println("Enter Night Cost");
        int nightCost = scanner.nextInt();
        return new Room(roomNumber,type,nightCost,true,true,null);
    }
    public void addRoom(ArrayList<Room> rooms){
        rooms.add(createRoom());
    }
    public Room getRoom(ArrayList<Room> rooms, int roomNumber){
        for(Room room : rooms){
            if(room.getRoomNumber()==roomNumber){
                return room;
            }
        }
        return null;
    }
    public void updateRoom(ArrayList<Room> rooms, int index){
        if(index<0 ||index>rooms.size()){
            System.out.println("Invalid");
        }else{
            rooms.set(index,createRoom());
        }
    }
    public void deleteRoom(ArrayList<Room> rooms, int index){
        if(index<0 ||index>rooms.size()){
            System.out.println("Invalid");
        }
        else{
            rooms.remove(index);
        }

    }
    public void display(ArrayList<Room> rooms){
        int i = 1;
        for(Room room: rooms){
            System.out.println(i+++"." + room.toString());
        }
    }
    public ArrayList<Room> getEmptyRooms(ArrayList<Room> rooms){
        ArrayList<Room> emptyRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.isEmpty()){
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }
    public ArrayList<Room> getOccupiedRooms(ArrayList<Room> rooms){
        ArrayList<Room> occupiedRooms = new ArrayList<>();
        for (Room room : rooms){
            if(room.isEmpty() == false){
                occupiedRooms.add(room);
            }
        }
        return occupiedRooms;
    }

    public Room selectRoom(ArrayList<Room> rooms){
        Scanner scanner = new Scanner(System.in);
        display(rooms);
        System.out.print("Select Room: ");
        int index = scanner.nextInt() - 1;
        if(index<0 || index>= rooms.size()){
            System.out.println("Invalid Selection");
        }
        else{
            return rooms.get(index);
        }
        return null;
    }
    @Override
    public String toString() {
        if(guest != null)
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", nightCost=" + nightCost +
                ", empty=" + empty +
                ", clean=" + clean +
                ", guest=" + guest.getName() +
                ", nights=" + guest.getNights() +
                '}';
        else{
            return "Room{" +
                    "roomNumber=" + roomNumber +
                    ", roomType=" + roomType +
                    ", nightCost=" + nightCost +
                    ", empty=" + empty +
                    ", clean=" + clean +
                    ", guest= Null"  +
                    '}';
        }
    }
}
