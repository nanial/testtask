package by.nanial.testtask.controller;

import by.nanial.testtask.view.Menu;
import by.nanial.testtask.viewImpl.MenuConsole;

public class Runner {
    public static void main(String[] args) {

        Menu console = new MenuConsole();
        console.userService();
    }
}
