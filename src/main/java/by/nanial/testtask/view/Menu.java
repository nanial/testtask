package by.nanial.testtask.view;

import by.nanial.testtask.apiBusiness.UserManager;
import by.nanial.testtask.business.UserManagerImpl;


public interface Menu {

    UserManager userManager = new UserManagerImpl();
    void login();
    void userService();
    void adminPanel();
}
