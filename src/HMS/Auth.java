package HMS;

import java.util.Scanner;

public class Auth {
    private final String userName = "amr";
    private final String password = "nana";

    public boolean login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("UserName: ");
        String userName = scanner.next();

        System.out.println("Password: ");
        String password = scanner.next();

       if(checkAuth(userName,password)){
           System.out.println("Logged In Successfully!");
           return true;
       }
       System.out.println("Invalid Username or Password");
        return false;
    }
    private boolean checkAuth(String userName,String password){
        if(userName.equals(this.userName)&&password.equals(this.password)){
            return true;
        }
        return false;
    }

}
