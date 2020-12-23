package by.nanial.testtask.business;

import by.nanial.testtask.apiBusiness.UserManager;
import by.nanial.testtask.apiBusiness.UserReader;
import by.nanial.testtask.apiDao.UserDao;
import by.nanial.testtask.dao.UserDaoImpl;
import by.nanial.testtask.domain.Role;
import by.nanial.testtask.domain.User;
import by.nanial.testtask.validator.EmailValidator;
import by.nanial.testtask.validator.PhoneValidator;
import java.util.ArrayList;
import java.util.List;


public class UserManagerImpl implements UserManager {

    UserDao dao = new UserDaoImpl();
    EmailValidator emailValidator = new EmailValidator();
    PhoneValidator phoneValidator = new PhoneValidator();
    UserReader reader = new UserReaderImpl();
    List<User>users = new ArrayList<>();

    @Override
    public void createNewUser(List<String> data) {
        User user = new User(data.get(0),data.get(1),new ArrayList<String>(),
                new ArrayList<Role>());
        setCheckedData(user,data);
        this.users.add(user);
        save(this.users);

    }
    @Override
    public void updateUser(int id, List<String>data) {
        User user = this.infoUser(id);
        user.setName(data.get(0));
        user.setSurname(data.get(1));
        setCheckedData(user,data);
        this.users.add(user);
        save (users);
    }
    private User setCheckedData(User user, List<String>data){
        for (String s : data){
            if(emailValidator.validate(s)){
                user.setEmail(s);
            }
            if(phoneValidator.validate(s) && user.getPhoneNumbers().size() < 3){
                user.getPhoneNumbers().add(s);
            }
            if(Role.contains(s.toUpperCase()) &&
                    Role.hasPermission(user, Role.valueOf(s.toUpperCase()))){
                user.getRoles().add(Role.valueOf(s.toUpperCase()));
            }
        }return user;
    }
    @Override
    public boolean deleteUser(int id) {
        boolean isDeleted = false;
        for (User user : this.users){
            if(user.getId() == id){
                this.users.remove(user);
                isDeleted = true;
            }
        }
        save (users);
        return isDeleted;
    }
    @Override
    public void save(List<User> users) {
        dao.save(users);
    }
    @Override
    public User infoUser(int id) {
        return dao.infoUser(id);
    }
    @Override
    public List<User> getListUserFromFile() {
        return dao.getListUser();
    }
    @Override
    public List<User> getUsers() {
        return users;
    }
}

