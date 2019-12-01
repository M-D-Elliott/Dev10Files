package exercises7;

public class DifferentKettleOfFish {
    public void run() {
        for(int fish = 1; fish <= 10; fish++){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }
        }

    }
}
