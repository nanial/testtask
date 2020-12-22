package by.nanial.testtask.domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    List<User>users = new ArrayList<>();
    public List<User> addToList(User user){
        users.add(user);
        return users;
    }
}
