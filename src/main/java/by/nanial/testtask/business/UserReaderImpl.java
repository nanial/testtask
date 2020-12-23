package by.nanial.testtask.business;

import by.nanial.testtask.apiBusiness.UserReader;
import by.nanial.testtask.domain.Role;
import by.nanial.testtask.validator.PhoneValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserReaderImpl implements UserReader {

    List<String> userData = new ArrayList<>();

    public List<String> getUserData(){
        int phoneCounter = 0;
        int roleCounter = 0;
        System.out.println("Input your name, surname, email, phone numbers, role, please");
        this.read();
        for (String s : userData) {
            if (new PhoneValidator().validate(s)) {
                phoneCounter++;
            }
        }
        for (String s : userData) {
            if(Role.contains(s.toUpperCase())){
                roleCounter++;
            }
        }
            if (phoneCounter > 3 || roleCounter > 2){
                System.out.println("Number of your phones/roles is excessive try again, please");
                userData = new ArrayList<>();
                this.read();
            }
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
    public int readId() {
        System.out.println("Input your id, please");
        return new Scanner(System.in).nextInt();
    }
}
