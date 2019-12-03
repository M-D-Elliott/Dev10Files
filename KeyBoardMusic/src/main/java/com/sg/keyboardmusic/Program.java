package com.sg.keyboardmusic;

import com.sg.keyboardmusic.App.App;
import com.sg.keyboardmusic.UserIO.UserIO;
import com.sg.keyboardmusic.UserIO.UserIOConsoleImpl;

public class Program {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        new App(io).run();
    }
}
