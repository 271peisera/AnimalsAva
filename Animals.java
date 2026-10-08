import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Animals {
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayCollection<String> list = new ArrayCollection<>(500);
        File f1 = new File("Animals.txt");

        try (Scanner scanner = new Scanner(f1)) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }

        ArrayCollection<Character> letters = new ArrayCollection<>();

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            letters.add(letter);
        }

        boolean playAgain = true;

        Scanner input = new Scanner(System.in);

        

        while (playAgain) {
            ArrayCollection<String> newList = list;
            int count = 0;
            boolean play = true;

            char randomLetter = (char)('A' + (int)(Math.random() * 26));
            Character start = letters.get(randomLetter);

            while (play) {

                System.out.println(
                    "Enter an animal starting with the letter " + start
                );

                String animal = input.nextLine();

                if (newList.contains(animal) && animal.charAt(0) == start) {
                    count++;
                    newList.remove(animal);
                }
                else {
                    play = false;
                    System.out.println("You named " + count + " animals!");
                }
            }

            System.out.println("Do you want to play again?");
            playAgain = input.nextBoolean();
            input.nextLine();
        }
    }
}