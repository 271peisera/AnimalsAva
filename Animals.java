import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Animals{
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        File f1 = new File("Animals.txt");

        try (Scanner scanner = new Scanner(f1)) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }

        
        ArrayList<Character> letters = new ArrayList<>();
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            letters.add(letter);
        }

        
        boolean playAgain = true;

        Scanner input = new Scanner(System.in);

        while (playAgain){
            int count = 0;
            boolean play = true;
            Character start = letters.get((int)(Math.random() * letters.size()));
            while(play){
                
                System.out.println("Enter an animal starting with the letter " + start);
                String animal = input.nextLine();
                if(list.contains(animal) && animal.charAt(0) == start){
                    count++;
                }
                else{
                    play = false;
                    System.out.println ("You named " + count + " animals!");
                }
                
        }
            System.out.println("Do you want to play again?");
        playAgain = input.nextBoolean();
        input.nextLine();
            
        }
        
        

    }
}