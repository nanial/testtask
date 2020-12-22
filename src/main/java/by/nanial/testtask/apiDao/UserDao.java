package by.nanial.testtask.apiDao;

import by.nanial.testtask.domain.User;
import java.util.List;

public interface UserDao {

    User infoUser(int id);
    List<User> getListUser();
    void save(List<User> users);
    boolean deleteUser(int id);

}
