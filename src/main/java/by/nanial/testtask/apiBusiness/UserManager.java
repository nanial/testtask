package by.nanial.testtask.apiBusiness;

import by.nanial.testtask.domain.User;

import java.util.List;

public interface UserManager {

    void createNewUser(List<String> data);
    void updateUser(int id, List<String>data);
    boolean deleteUser(int id);
    void save(List<User> users);
    User infoUser(int id);
    List<User> getListUserFromFile();
    List<User> getUsers();
}
