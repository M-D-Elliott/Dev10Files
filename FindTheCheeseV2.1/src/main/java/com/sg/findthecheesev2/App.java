
package com.sg.findthecheesev2;

import com.sg.findthecheesev2.game.Game;
import com.sg.findthecheesev2.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIOConsoleImpl myio = new UserIOConsoleImpl();
        Game game = new Game(myio);
        game.run();
    }
}
