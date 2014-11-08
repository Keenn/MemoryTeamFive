package TeamFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TeamFive
 *
 * This class holds the main logic of the program.
 */
public class GameHandler {

    public static void main(String[] args) {

        List<Card> listOfCards = new ArrayList<>();
        Board board;

         Scanner sc = new Scanner(System.in);
         GameHandler gameHandler = new GameHandler();
         gameHandler.startMenu(sc);
      
    }

    /**
     *
     * @param sc scanner from Main
     * @param gameHandler Object of GameHandler
     *
     * Intromenu
     */
    private void startMenu(Scanner sc) {
        List<Player> listOfPlayers = new ArrayList<>();

        printStartMenu();

        switch (getUserInt(sc, 1, 2)) {
            case 1: // Start new Games
                listOfPlayers = addPlayer(listOfPlayers, sc); // Add player to the list
                playGame(listOfPlayers, sc);  //funktion är ej klar
                break;

            case 2: // Exit the game
                System.exit(1);
                break;

            default:
                System.out.println("Invalid input");
                break;
        }
    }

    /**
     * This method start with initalize the Board. The method continues
     * accordingly to the games Print out result at the end. The method will
     * exit if there are no more player in the listOfPlayer
     *
     * @param listOfPlayer
     * @param scan
     */
    private void playGame(List<Player> listOfPlayer, Scanner scan) {

        while (true) {
            Board board = addBoard(scan);

            /*
             * här börjar loopen playerturn/
             */
            result(listOfPlayer);
            listOfPlayer = continueGames(listOfPlayer, scan);
            if (listOfPlayer.isEmpty()) {
                System.out.println("|---No more Player---\n|");
                System.out.println("|<-><-><-><-><-><-><-><-><->|");
                System.out.println("|     ---GAMES OVER---|");
                System.out.println("|<-><-><-><-><-><-><-><-><->|");
                System.exit(0);
            }
        }

    }

    /**
     * Printing out score for each player
     *
     * @param listOfPlayer
     */
    private void result(List<Player> listOfPlayer) {

        for (Player player : listOfPlayer) {
            System.out.printf("%s have %d points", player, player.getScore());
        }
    }

    /**
     * This Method ask if player want to continue or quit
     *
     * @param listOfPlayer
     * @param scan
     * @return the new list of player who wanna continue playing memory
     */
    private List<Player> continueGames(List<Player> listOfPlayer, Scanner scan) {
        List<Player> newList = new ArrayList<>();
        printContinueGames();

        for (Player player : listOfPlayer) {
            System.out.printf("%s: ");
            if (getUserInt(scan, 1, 2) == 1) {
                newList.add(player);
            }
        }
        return newList;
    }

    /**
     * This method ask the user for 3 difference size of the board.
     *
     * @param scan
     * @return new Board
     */
    private Board addBoard(Scanner scan) {
        Board board = null;

        printBoard();

        switch (getUserInt(scan, 1, 3)) {
            case 1:
                board = new Board(2);
                break;

            case 2:
                board = new Board(4);
                break;

            case 3:
                board = new Board(6);
                break;

        }
        return board;
    }

    /**
     * This method ask the user for Name and add new player to the list.
     *
     * @param listOfPlayer
     * @param scan
     * @return listOfPlayer with new added player to the list
     */
    public List<Player> addPlayer(List<Player> listOfPlayer, Scanner scan) {
        while (true) {
            printPlayerMenu(listOfPlayer.size());
            if (1 == getUserInt(scan, 1, 2)) {
                System.out.println("Enter player name");
                listOfPlayer.add(new User(getUserString(scan)));
                System.out.printf("<<< %s have been added >>> \n",listOfPlayer.get(listOfPlayer.size()-1));
            } else {
                break;
            }
        }
        /*  // Add new BotPlayer Missing class bot
        
         while (true) {
         System.out.println("Press [1] for add a Bot Player");
         System.out.println("Press [2] for done");
         if (1 == getUserInt(1, 2)) {
         listOfPlayer.add(addBot());
         } else {
         break;
         }
         }*/

        return listOfPlayer;
    }

    /**
     * This method ask the user for int as an input
     *
     * @param sc
     * @return an int from the user
     */
    public int getUserInt(Scanner sc) {
        int intInput = 0;
        while (true) {
            try {
                System.out.println("->");
                intInput = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input! Please only use numbers");
            }
        }
        return intInput;
    }

    /**
     * This method ask user for a number from min to max
     *
     * @param sc
     * @param min the lowers number
     * @param max highest number
     * @return
     */
    public int getUserInt(Scanner sc, int min, int max) {
        int intInput = 0;
        while (true) {
            try {
                System.out.printf("Choose from [%d]- [%d] :", min, max);
                System.out.println("->");
                intInput = Integer.parseInt(sc.next());
                if (intInput <= max && intInput >= min) {
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input! Please  use only numbers");
            }
        }
        return intInput;
    }

    /**
     * Ask user for String as input
     *
     * @param sc
     * @return String from the user
     */
    public String getUserString(Scanner sc) {
        System.out.println("->");
        return sc.next();
    }

    private void printStartMenu() {
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
        System.out.println("| Welcome to TeamFive Memory game!");
        System.out.println("| [1] Start new game");
        System.out.println("| [2] Exit the game");
        System.out.println("|<-><-><-><-><-><-><-><-><->|");

    }

    private void printPlayerMenu(int numberOfPlayers) {
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
        System.out.println("| Current players: " + numberOfPlayers);
        System.out.println("| [1] Add new player");
        System.out.println("| [2]  Continue");
        System.out.println("|<-><-><-><-><-><-><-><-><->|");

    }

    private void printBoard() {
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
        System.out.println("| Choose the size for the game");
        System.out.println("| [1] 2x2 ");
        System.out.println("| [2] 4x4 ");
        System.out.println("| [3] 6x6 ");
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
    }

    private void printContinueGames() {
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
        System.out.println("| Would you like to play again?");
        System.out.println("| [1] Continue");
        System.out.println("| [2] Quit");
        System.out.println("|<-><-><-><-><-><-><-><-><->|");
    }
}
