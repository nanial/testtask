package by.nanial.testtask.viewImpl;
import by.nanial.testtask.apiBusiness.UserManager;
import by.nanial.testtask.apiBusiness.UserReader;
import by.nanial.testtask.business.UserManagerImpl;
import by.nanial.testtask.business.UserReaderImpl;
import by.nanial.testtask.view.Menu;

public class MenuConsole implements Menu {
    UserReader reader = new UserReaderImpl();
    UserManager manager = new UserManagerImpl();
    public void login() {

    }
    public void userService() {

        //manager.createNewUser(reader.getUserData());
        //manager.updateUser(1, reader.getUserData());
        System.out.println(manager.getListUser());
    }
    public void adminPanel() {

    }
}
