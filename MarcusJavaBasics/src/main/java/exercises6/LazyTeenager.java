/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises6;

import java.util.Random;

public class LazyTeenager {
    private int chanceRoomIsClean = 5;
    public void run() {
        Random random = new Random();
        boolean clean = false;
        int count = 0;
        do {
            count++;
            System.out.println("Clean your room!(x" + count + ")");
            if(random.nextInt(100) + 1 < chanceRoomIsClean * count) {
                clean = true;
                System.out.println("Your room is clean?!");
            }
        } while(!clean && count < 15);
        if(count >= 15) {
            System.out.println("You never cleaned your room!");
        }
    }
}
