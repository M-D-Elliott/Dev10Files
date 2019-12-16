package com.sg.caesarcipher;

import com.sg.caesarcipher.objects.Cipher;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Cipher cipher = new Cipher();
    
//        List<String> data = new ArrayList<>(){{
//            add("Hello world");
//            add("Yo Nicholas");
//            add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
//            add("Hello Mac and Joe from Nicolas and Marcus");
//        }};
//
//        List<String> encryptedData = new ArrayList<>();
//        
//        for(String str : data){
//            String out = cipher.encrypt(str);
//            System.out.println(out);
//            encryptedData.add(out);
//        }
//        
//        for (String string : encryptedData) {
//            System.out.println(cipher.decrypt(string));
//        }

//        cipher.bruteForce("xkmkpiu");
        cipher.bruteForce("MJQQT RFH FSI OTJ KWTR SNHTQFX FSI RFWHZX");
    }
}
