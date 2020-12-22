package by.nanial.testtask.business;

import by.nanial.testtask.apiBusiness.UserReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserReaderImpl implements UserReader {

    List<String> userData = new ArrayList<>();

    public List<String> getUserData(){

        System.out.println("Input your name, surname, email, phone numbers, role, please");
       /* try (@SuppressWarnings("")
             Scanner scan = new Scanner(System.in)) {*/
            this.read();

            if(userData.size() > 8 || userData.size() < 5){
               System.out.println("Input your name, surname, email, phone numbers, " +
                        "role correctly, please");
                userData = new ArrayList<>();
                this.read();
            }
       /* }catch (InputMismatchException e){
            e.getMessage();
        }*/
        return userData;
    }
    private void read(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (!s.equals("q")){
                userData.add(s);
            }
            else {
                break;
            }
        }
    }
    //to correction
    public int readId() {
        //to much scanners!!! not works
        System.out.println("Input your id, please");
        return new Scanner(System.in).nextInt();
    }
}
