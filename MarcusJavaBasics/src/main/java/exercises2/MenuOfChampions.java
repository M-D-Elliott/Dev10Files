package exercises2;

public class MenuOfChampions {
    private String name = "Night Vale";
    
    private String food1 = "Steak";
    private int food1Price = 2;
    
    private String food2 = "Chicken";
    private int food2Price = 3;
    
    private String food3 = "Pork";
    private int food3Price = 4;
    
    public void run() {
        String banner = ".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.";
        System.out.println(banner);
        System.out.println("");
        System.out.println("Welcome to restaurant " + name);
        System.out.println("");
        System.out.println(banner);
        System.out.println("");
        System.out.println(food1 + ": $" + food1Price);
        System.out.println(food2 + ": $" + food2Price);
        System.out.println(food3 + ": $" + food3Price);
    }
}
