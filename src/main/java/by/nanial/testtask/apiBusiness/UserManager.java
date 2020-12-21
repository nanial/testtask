package by.nanial.testtask.apiBusiness;

import by.nanial.testtask.domain.Role;
import by.nanial.testtask.domain.User;

import java.util.List;

public interface UserManager {

    User createNewUser(List<String> data);
    void updateUser(int id);
    boolean deleteUser(int id);
    void save(User user);
    User infoUser(int id);
    List<User> getListUser();
}
