import java.util.Scanner;

public class RockPaperScissorsTwo
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        // TODO

        // DONE //
        // 1. Lav metode, der validerer inputs, den skal tage en int og returnerer en int alt efter valg
        // og hvis inputet er ugyldigt skal de have besked.

        // 2. Lav en metode, der validere om inputet er ens og returner true/false
        // 3. Lav din draw() der modtager to parametre int og printer den sætning der passer
        // 4. Lav din winLose() der tager to parametre og retunerer, hvem der har vundet


        // Greeting
        System.out.println("Welcome to Rock, Paper, Scissors!" + '\n' + "Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println('\n' + "Welcome, " + name + ".Please choose a game mode." + '\n' + " Press 1 for single player and 2 for multiplayer");


        // Select playmode
        int selectPlayMode = scanner.nextInt();

        if(selectPlayMode == 1)
        {
            int playerOneInput = scanner.nextInt();
            int playerTwoInput = scanner.nextInt();
            singlePlayer(playerOneInput);
        }
        else if(selectPlayMode == 2)
        {
            int playerOneInput = scanner.nextInt();
            int playerTwoInput = scanner.nextInt();
            multiPlayer(playerOneInput, playerTwoInput);
        }


        // Method calls
        isPlayerInputTheSame(playerOneInput, playerTwoInput);


        // Check that no players input an invalid input
        if(playerOneInput < 4 || playerOneInput > 6 && playerTwoInput < 4 || playerTwoInput > 6)
        {
            System.out.println("At least one of the values is invalid. Please enter a value between 4 and 6.");
        }


        choices(playerOneInput, playerTwoInput);
    }



    // Check if player inputs are the same
    public static boolean isPlayerInputTheSame(int playerOneInput, int playerTwoInput)
    {
        if(playerOneInput == playerTwoInput)
        {
            System.out.println("Both players have chosen " + (playerOneInput + playerTwoInput) / 2);
            return true;
        }
        else
        {
            return false;
        }
    }



    // Single Player
    public static void singlePlayer(int playerOneInput)
    {
        System.out.println("Welcome to Rock, Paper, Scissors - Single Player Mode" + '\n' + "Please choose 4 for rock, 5 for paper, and 6 for scissors.");


        computerChoice();
    }


    // Computer Choice
    public static int computerChoice()
    {
        int min = 4;
        int max = 6;
        int computerValue = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println(computerValue);

        if(computerValue == 4)
        {
            System.out.println("Computer's chosen rock");
        }
        else if(computerValue == 5)
        {
            System.out.println("Computer's chosen paper");
        }
        else if(computerValue == 6)
        {
            System.out.println("Computer's chosen scissors");
        }

        return computerValue;
    }
}
