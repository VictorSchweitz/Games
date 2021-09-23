import java.util.Scanner;

public class RockPaperScissors
{
    static Scanner scanner = new Scanner(System.in);
    static boolean isPlayMode;

    public static void main(String[] args)
    {
        // Greet the player
        System.out.println("Welcome to Rock, Paper, Scissors!" + '\n' + "Please enter your name:");

        // Ask player for name
        String name = scanner.nextLine();
        System.out.println("Welcome, " + name + "!" + '\n' + "Please enter a play mode:" + '\n' + "Press 1 for single player and 2 for multiplayer.");

        // Choose play mode
        int playMode = scanner.nextInt();

        // Run play mode
        if(playMode == 1)
        {
            // isPlayMode = true equals single player
            isPlayMode = true;

            // Run single player method
            singlePlayer();
        }
        else if(playMode == 2)
        {
            // isPlayMode = false equals multiplayer
            isPlayMode = false;

            // Run single player mode
            multiPlayer();
        }
        else
        {
            // If something different from one or two has been entered, display this message
            System.out.println("Please enter a valid number to select play mode");
        }

    }



    // Computer choice - generating number between 4 and 6
    public static int computerChoice()
    {
        // Setting min and max value
        int min = 4;
        int max = 6;

        /**
          Since Math.random() returns a double and the computer plays an int, the random number has to be cast to an int.
          And since Math.random() by default returns a float between 0 and 1, the number has to be rounded down to the nearest integer using Math.floor().
          The rest of the formula is mathemagic.
         */
         int computerValue = (int) Math.floor(Math.random() * (max - min + 1) + min);

         // Printing out computer's choice
         System.out.println(computerValue);


         // Checking computer value and print message based on that
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

         // Returning computer value
         return computerValue;
    }


    // Single Player
    public static void singlePlayer()
    {
        System.out.println("Welcome to Rock, Paper, Scissors - Single Player Mode" + '\n' + "Please choose 4 for rock, 5 for paper, and 6 for scissors.");

        int playerOneChoice = checkValidPlayerInput();
        int computerChoice = computerChoice();

        boolean isInputSame = samePlayerInputs(playerOneChoice, computerChoice);

        if(isInputSame)
        {
            System.out.println("Draw!");
        }
        else
        {
            winLose(playerOneChoice, computerChoice);
        }

    }

    // Method for multiplayer mode
    public static void multiPlayer()
    {
        // Greeting
        System.out.println("Welcome to Rock, Paper, Scissors - Multiplayer Mode" + '\n' + "Please choose 4 for rock, 5 for paper, and 6 for scissors.");

        // Getting user input
        int playerOneChoice = checkValidPlayerInput();
        int playerTwoChoice = checkValidPlayerInput();


        // Using boolean to check if both inputs are the same
        boolean isInputSame = samePlayerInputs(playerOneChoice, playerTwoChoice);

        // If so, call draw method
        draw(isInputSame);


        // If the inputs aren't the same, return the winner and loser
        if(!isInputSame)
        {
            winLose(playerOneChoice, playerTwoChoice);
        }
    }

    // Draw
    public static void draw(boolean isInputSame)
    {
        if(isInputSame)
        {
            System.out.println("Draw!");
        }
    }

    // Checking if player inputs are valid
    public static int checkValidPlayerInput()
    {
        int playerChoice = scanner.nextInt();

        if(playerChoice < 4 || playerChoice > 6)
        {
            System.out.println("Please enter a valid input");

            if(isPlayMode)
            {
                singlePlayer();
            }
            else
            {
                multiPlayer();
            }
        }
        return playerChoice;
    }


      // Same Player Inputs
      public static boolean samePlayerInputs(int playerOneChoice, int playerTwoChoice)
      {

          // Logging players' choices
          if(playerOneChoice == 4 && playerTwoChoice == 4)
          {
              System.out.println("You've chosen rock");
              return true;
          }
          else if(playerOneChoice == 5 && playerTwoChoice == 5)
          {
              System.out.println("You've chosen paper");
              return true;
          }
          else if(playerOneChoice == 6 && playerTwoChoice == 6)
          {
              System.out.println("You've chosen scissors");
              return true;
          }

          return false;
       }


    // Win/Lose
    public static void winLose(int playerOneChoice, int playerTwoChoice)
    {
        if(playerOneChoice == 4 && playerTwoChoice == 5)
        {
            System.out.println("Player 2 wins!");
        }
        else if(playerOneChoice == 4 && playerTwoChoice == 6)
        {
            System.out.println("Player 1 wins!");
        }
        else if(playerOneChoice == 5 && playerTwoChoice == 4)
        {
            System.out.println("Player 1 wins!");
        }
        else if(playerOneChoice == 5 && playerTwoChoice == 6)
        {
            System.out.println("Player 2 wins!");
        }
        else if(playerOneChoice == 6 && playerTwoChoice == 4)
        {
            System.out.println("Player 2 wins!");
        }
        else if(playerOneChoice == 6 && playerTwoChoice == 5)
        {
            System.out.println("Player 1 wins!");
        }
    }

}