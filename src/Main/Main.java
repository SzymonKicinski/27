package Main;

import Animal.Bird;
import Animal.Dog;
import Animal.Parrot;
import Animal.Penguin;
import Button.Button;
import Gearbox.Gearbox;
import ISaveable.ISaveable;
import ListItem.MyLinkedList;
import ListItem.Node;
import ListItem.SearchTree;
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

//       class ClickListner implements Button.OnClickListner {
//           public ClickListner() {
//               System.out.println("I've been attached");
//           }
//
//           @Override
//           public void onClick(String title) {
//               System.out.println(title + " was clicked");
//           }
//       }
//       btnPrint.setOnClickListner(new ClickListner());
        /*btnPrint.setOnClickListner(new Button.OnClickListner() {
            @Override
            public void onClick(String title) {
                System.out.println( title + " -> I have been clicked Wheee");
            }
        });
       listen();*/

        /*Dog dog = new Dog("Reksio");
        dog.eat();
        dog.breathe();

        Parrot parrot = new Parrot("Parrot");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Penguin");
        penguin.fly();*/

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";


        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new Node(s));
        }


        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.removeItem(new Node("4"));
        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());


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
