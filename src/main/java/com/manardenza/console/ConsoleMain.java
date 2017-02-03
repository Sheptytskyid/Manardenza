package com.manardenza.console;

import java.io.IOException;

public class ConsoleMain {

    private ContentsUserMenu contentsUserMenu;

    public ConsoleMain(ContentsUserMenu contentsUserMenu) {
        this.contentsUserMenu = contentsUserMenu;
    }

    public void consoleMain() throws IllegalAccessException, InstantiationException, IOException {
        contentsUserMenu.mainMenu();
        contentsUserMenu.serviceMenu();
    }
}
