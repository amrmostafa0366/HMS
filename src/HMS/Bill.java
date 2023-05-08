package HMS;

import java.util.ArrayList;
import java.util.Scanner;

enum BillDetails{accommodation,food,laundry}
public class Bill {
    private double cost;
    private String details;

    public Bill(double cost, String details){
        this.cost = cost;
        this.details = details;
    }

    public Bill() {
    }

    public double getBill() {
        return cost;
    }

    public void setBill(double cost) {
        this.cost = cost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private Bill createBill(double cost,String details){
        return new Bill(cost,details);
    }
    public void addBill(Guest g){
        ArrayList<Bill> bills = g.getBills();
        bills.add(createBill(accommodation(g),"accomoomomomomo"));
    }
    public void readBill(){

    }
    public void updateBill(){

    }
    public void deleteBill(){

    }

    public Bill addBill(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bill Details: ");
        String details = scanner.nextLine();
        System.out.print("Bill Cost: ");
        int cost = scanner.nextInt();
        return new Bill(cost,details);
    }

    private double accommodation(Guest guest){
        return guest.getNights() * guest.getRoom().getNightCost();
    }

    public void display(ArrayList<Bill> bills){
        int i = 1;
        for(Bill bill: bills){
            System.out.println(i+++"." + bills);
        }
    }

    public String toString(){
        return "Bill{" +
                "Details= " + details +"" +
                ", Cost= " + cost +
                '}';
    }
}
