package Main;

import Button.Button;
import Gearbox.Gearbox;
import ISaveable.ISaveable;
import Monster.Monster;
import Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    public static void main(String[] args) {
/*

        Player player = new Player("Tim", 10, 15);
        System.out.println(player.toString());

        saveObject(player);
        player.setHitPoints(8);
        System.out.println(player.toString());
        saveObject(player);

        System.out.println(player.toString());

        System.out.println("========================");

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf.toString());
        System.out.println( "Strength=" + ((Monster) werewolf).getStrength());
        saveObject(werewolf);
*/

        /*Gearbox mcLaren = new Gearbox(6);
        Gearbox.Gear first= mcLaren.new Gear(1, 12.3);
        System.out.println(first.driveSpeed(1000));

        Gearbox.Gear second = mcLaren.new Gear(2, 15.4);
        System.out.println(second.driveSpeed(1200));

        Gearbox.Gear third = mcLaren.new Gear(3, 21.4);
        System.out.println(third.driveSpeed(1300));*/

       /* Gearbox mcLaren = new Gearbox(6);
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGearVoid(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGearVoid(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGearVoid(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));*/

       class ClickListner implements Button.OnClickListner {
           public ClickListner() {
               System.out.println("I've been attached");
           }

           @Override
           public void onClick(String title) {
               System.out.println(title + " was clicked");
           }
       }
       btnPrint.setOnClickListner(new ClickListner());
       listen();

    }

    private static void listen() {
        boolean q = false;
        while (!q) {
            int choic = scanner.nextInt();
            scanner.nextLine();
            switch (choic) {
                case 0:
                    q = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }
        }
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        boolean quit = false;
        int index = 0;
        System.out.println("Choose");
        System.out.println("1 to enter a string");
        System.out.println("0 to quit");
        while (!quit) {
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit =true;
                    break;
                case 1:
                    System.out.println("Enter a string:");
                    String s = scanner.nextLine();
                    values.add(s);
                    index++;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable object) {
        ArrayList<String> values = readValues();
        object.read(values);
        System.out.println("Main.loadObject()");
    }
}
