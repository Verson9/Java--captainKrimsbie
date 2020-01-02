package ships;

import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);

    static Player player1;
    static Player player2;


    private void initializationOfTheGame(){
        System.out.println("""
                Witaj w "Captain Krimsby"
                W dalszej części tworzenia gry możesz w każdym momencie wpisać "BACK" aby wrócić do poprzedniego kroku
                lub "QUIT" by wyjść.

                Powodzenia!
                """);
    }

    void chooseGameType(){
        System.out.println("""
                Wybierz tryb gry.
                -"PvP" aby grać przeciwko drugiemu graczowi.
                -"PvC" aby grać przeciwko komputerowi.
                """);
        String choice = sc.nextLine().toLowerCase();
        Utilities.checkIfTheChoiceIsQuit(choice);
        switch (choice) {
            case "pvp" -> {
                System.out.println("Wybrałeś tryb PvP");
                pvpGame();
            }
            case "pvc" -> {
                System.out.println("Wybrałeś tryb PvC");
                pvcGame();
            }
            case "back" -> {
                System.out.println("Nie było wcześniej opcji wyboru\n" +
                        "Wracamy do wyboru typu gry.");
                chooseGameType();
            }
            default -> {
                System.out.println("Podaj tryb gry, lub wpisz EXIT");
                chooseGameType();
            }
        }
    }

    private void pvpGame(){
        String p1name = createPlayer();
        player1 = new Person(p1name);
        player1.putShips();

        String p2name = createPlayer();
        player2 = new Person(p2name);
        player2.putShips();
    }

    private String createPlayer(){
        System.out.println("Wpisz imię gracza.");
        String name = sc.nextLine();
        System.out.println("Witaj " + name);
        System.out.println("Rozmieść swoje statki.");
        return name;
    }

    private void pvcGame(){
        String p1name = createPlayer();
        player1 = new Person(p1name);
        Utilities.displayPersonField(player1.getOwnField());
        player1.putShips();
        System.out.println("Komputer stworzony.");
        player2 = new Computer();
        player2.putShips();
    }

    void shooting(){    }

    void start(){
        initializationOfTheGame();
        chooseGameType();
        shooting();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
