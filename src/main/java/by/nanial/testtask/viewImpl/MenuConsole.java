package by.nanial.testtask.viewImpl;
import by.nanial.testtask.apiBusiness.UserManager;
import by.nanial.testtask.apiBusiness.UserReader;
import by.nanial.testtask.business.UserManagerImpl;
import by.nanial.testtask.business.UserReaderImpl;
import by.nanial.testtask.view.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole implements Menu {
    UserReader reader = new UserReaderImpl();
    UserManager manager = new UserManagerImpl();
    public void login() {

    }
    public void userService() {
        System.out.println("Input 1 for create user, 2 for update user," +
                " 3 for list of users, 4 for info of certain user, 5 for delete user from list, " +
                "6 for exit");
        try (@SuppressWarnings("")
             Scanner scan = new Scanner(System.in)) {
            int choice = scan.nextInt();

            while (choice != 6) {
                switch (choice) {
                    case 1:
                        manager.createNewUser(reader.getUserData());
                        choice = commandLine(scan);
                        break;

                    case 2:
                        manager.updateUser(reader.readId(), reader.getUserData());
                        choice = commandLine(scan);
                        break;
                    case 3:
                        System.out.println(manager.getListUserFromFile());
                        choice = commandLine(scan);
                        break;
                    case 4:
                        System.out.println(manager.infoUser(reader.readId()));
                        choice = commandLine(scan);
                        break;
                    case 5:
                        manager.deleteUser(reader.readId());
                        choice = commandLine(scan);
                        break;
                    case 6:
                        //manager.save(manager.getUsers());
                        break;
                    default:
                        System.out.println("You have been done incorrect command");
                        choice = commandLine(scan);
                }
            }
        }catch (InputMismatchException e){
            e.getMessage();
        }
    }
    public void adminPanel() {

    }
    private int commandLine(Scanner scanner){

        System.out.println("Choice next operation");
        while (!scanner.hasNextInt()){
            System.out.println("Choice next operation");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
