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
import java.util.Objects;

public class UserManagerImpl implements UserManager {

    UserDao dao = new UserDaoImpl();//singleton
    UserReader reader = new UserReaderImpl();//singleton
    EmailValidator emailValidator = new EmailValidator();
    PhoneValidator phoneValidator = new PhoneValidator();

    public User createNewUser(List<String> data) {

        User user = new User(data.get(0),data.get(1),new ArrayList<String>(),new ArrayList<Role>());
        for (String s : data){
            if(emailValidator.validate(s)){
                user.setEmail(s);
            }
            if(phoneValidator.validate(s)){
                user.getPhoneNumbers().add(s);
            }
            if(Role.contains(s.toUpperCase()) && Role.permission(Role.valueOf(s.toUpperCase()))){
                user.getRoles().add(Role.valueOf(s.toUpperCase()));
            }
        }
        save(user);
        return user;
    }
    @Override
    public void updateUser(int id) {
        User user = this.infoUser(id);
        List<String>data = reader.getUserData();
        user.setName(data.get(0));
        user.setSurname(data.get(1));
        for (String s : data){
            if(emailValidator.validate(s)){
                user.setEmail(s);
            }
            if(phoneValidator.validate(s)){
                user.getPhoneNumbers().add(s);
            }
            if(Role.contains(s.toUpperCase()) && Role.permission(Role.valueOf(s.toUpperCase()))){
                user.getRoles().add(Role.valueOf(s.toUpperCase()));
            }
        }
            save (user);
    }
    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }
    @Override
    public User infoUser(int id) {
        return dao.infoUser(id);
    }
    @Override
    public List<User> getListUser() {
        return dao.getListUser();
    }
}
