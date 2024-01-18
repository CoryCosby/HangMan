import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        String word = randomWord(words);
        int missCount = 0; 
        char[] chars = word.toCharArray();
        char[] wordDashes = new char[chars.length];
        char[] misses = new char[6];
        

        Scanner scan = new Scanner(System.in);

        //adds dashes to wordDashes as wordDashes
        for (int i = 0; i < wordDashes.length; i++) {
            wordDashes[i] = '-';
        }
        
        while (missCount < 6) {
            System.out.print(gallows[missCount]);
            
            System.out.print("Word:   ");
            System.out.print(wordDashes);
            System.out.print("\n");

            System.out.print("Misses:   ");
            printMissedGuesses(misses);
            System.out.print("\n\n");

            System.out.print("Guess:   ");
            char guess = scan.nextLine().charAt(0);
            System.out.print("\n");

            if (checkGuess(guess, chars)) {
                updatewordDashes(wordDashes, chars, guess);
            } else {
                misses[missCount] = guess;
                missCount++;
            }

            if (Arrays.equals(wordDashes, word.toCharArray())) {
                System.out.print(gallows[missCount]);
                System.out.print("\nWord:   ");
                printWordDashes(wordDashes);
                System.out.println("\nGOOD WORK!");                
                break;
            }
        }

        if (missCount == 6) {
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + word + "'");
        }
        scan.close();
    }

        





    

    public static String randomWord (String[] wordBank) {
        int index = (int) (Math.random() * words.length);

        return words[index];
    }
    public static boolean checkGuess(char guess, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(guess == chars[i]) {
                
                return true;
            } 
        }
            return false;
        }
        
    public static void updatewordDashes(char[] wordDashes, char[] chars, char guess) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == guess) {
                wordDashes[i] = guess;
            }
        }
    }

    public static void printWordDashes(char[] wordDashes) {
        for (int i = 0; i < wordDashes.length; i++) {
                System.out.print(" " + wordDashes[i]);
            }
        System.out.print("\n");
    }

   public static void printMissedGuesses(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            System.out.print(misses[i]);
            }
       
        }
    }






