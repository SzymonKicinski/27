package Main;

import Button.Button;

import ISaveable.ISaveable;
import League.League;
import League.FootballPlayer;
import League.BaseballPlayer;
import League.Team;
import League.SoccerPlayer;
import ListItem.SearchTree;

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


//        String[] data = stringData.split(" ");
//        for (String s : data) {
//            tree.addItem(new Node(s));
//        }
//
//
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("3"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("5"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("0"));
//        tree.removeItem(new Node("4"));
//        tree.removeItem(new Node("2"));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node("9"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("8"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(new Node("6"));
//        tree.traverse(tree.getRoot());
//        tree.removeItem(tree.getRoot());
//        tree.traverse(tree.getRoot());
//        tree.removeItem(tree.getRoot());
//        tree.traverse(tree.getRoot());

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);

        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);

//        footballLeague.add(baseballTeam);
        footballLeague.showLeagueTable();

        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");
        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); // unchecked warning
        rawTeam.addPlayer(pat);     // unchecked warning

        footballLeague.add(rawTeam);     // unchecked warning

        League<Team> rawLeague = new League<>("Raw");
        rawLeague.add(adelaideCrows);     // no warning
        rawLeague.add(baseballTeam);    // no warning
        rawLeague.add(rawTeam);         // no warning

        League reallyRaw = new League("Really raw");
        reallyRaw.add(adelaideCrows);     // unchecked warning
        reallyRaw.add(baseballTeam);    // unchecked warning
        reallyRaw.add(rawTeam);         // unchecked warning


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
