package lesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataMarshalUnmarshall {
    public void run() throws FileNotFoundException{
        List<Dog> dogList = new ArrayList<>();
        
        dogList.add(new Dog("Beast", "Yellow Lab", 10));
        dogList.add(new Dog("Simon ", "German Shepard", 5));
        dogList.add(new Dog("Carlie", "Pit Bull", 8));
        
        
        PrintWriter pw = new PrintWriter(new File("dogs.txt"));
        
        for(Dog dog : dogList) {
            pw.write(dog.getName() + "::" + dog.getBreed() + "::" + dog.getAge() + "\n");
        }
        
        // queue up sending in memory,
        // so flush forces it into the file
        // right away.
        pw.flush();
        // closes the printWriter so that the file
        // returns to an accessable state to other programs.
        pw.close();
        
        List<Dog> dogListAgain = new ArrayList<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("dogs.txt")));
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            
            //double colon delimeter is standard for Software guild,
            // delimeter can be anything but usually is comma.
            // must be something that is not present in the data.
            String[] lineParts = line.split("::");
            
            Dog d = new Dog(lineParts[0], lineParts[1], lineParts[2]);
            
            dogListAgain.add(d);
            
        }
        // if a final entry did not exist
        // would throw error as it wouldn't have a place to end.
        for (Dog d : dogListAgain) {
            System.out.println(d.getName() + ", " + d.getBreed());
        }
    }
}
