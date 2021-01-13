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
        List<Integer> tempRoles = new ArrayList<>();
        System.out.println("Input your name, surname, email, phone numbers, role, please");
        this.read();
        for (String s : userData) {
            if (new PhoneValidator().validate(s)) {
                phoneCounter++;
            }
            if(Role.contains(s.toUpperCase())){
                tempRoles.add(Role.valueOf(s.toUpperCase()).getLevel());
            }
        }
        boolean flagToRepeatRead = false;
        for (int i = 0; i < tempRoles.size(); i++) {
            for (int k = i + 1; k < tempRoles.size(); k++) {
                if (tempRoles.get(i).equals(tempRoles.get(k))) {
                    System.out.println("Level of your roles is incompatible try again, please");
                    flagToRepeatRead = true;
                }
                if(tempRoles.get(i).equals(3) && tempRoles.size() > 1){
                    System.out.println("Level of your roles is incompatible try again, please");
                    flagToRepeatRead = true;
                }
            }
        }
        if (phoneCounter > 3 || tempRoles.size() > 2){
            System.out.println("Number of your phones/roles is excessive try again, please");
            flagToRepeatRead  = true;
        }
        if (flagToRepeatRead){
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
