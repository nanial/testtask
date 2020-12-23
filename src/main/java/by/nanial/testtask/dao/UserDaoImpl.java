package by.nanial.testtask.dao;

import by.nanial.testtask.apiDao.UserDao;
import by.nanial.testtask.domain.User;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User infoUser(int id) {
        User user = null;
        for (User u : this.getListUser()){
            if(u.getId() == id){
                user = u;
            }
        }
        return user;
    }

    public List<User> getListUser() {

        List<User> users = new ArrayList<>();

        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream
                    ("users.xml")));
            users = ((List<User>) decoder.readObject());
        } catch (IOException io) {
            io.getMessage();
        }
        return users;
    }

    @Override
    public void save(List<User> users) {

        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream
                    ("users.xml")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        encoder.writeObject(users);
        encoder.close();
    }
}
