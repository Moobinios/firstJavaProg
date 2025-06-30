
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    static int IDcounter = 0;

    public static void main(String[] args) {
        Note obj = new Note();
        Scanner input = new Scanner(System.in);
        System.out.println("welcome to my program! type \"commands\" to see the available list of commands!!");
        String userInput = "";
        File file = new File("currentID.txt");

        while (!userInput.equals("exit")) {
            try {
                Scanner reader = new Scanner(file);
                IDcounter = reader.nextInt();
                reader.close();
            } catch (Exception ignored) {
            }
            userInput = input.nextLine();
            if (userInput.equals("commands")) {
                System.out.println("add *note* -> adds a note to the system.\nview *ID* or view *blank* to either view a note by its ID or view alone to see all the current notes.\ndelete *ID* \ndelete all\nexit");
            } else if (userInput.startsWith("add")) {
                obj.add(userInput, IDcounter);
            } else if (userInput.startsWith("view")) {
                obj.view(userInput, IDcounter);
            }
            else if(userInput.equalsIgnoreCase("delete all")){
                obj.deleteAll(userInput,IDcounter);
            }
            else if (userInput.startsWith("delete")) {
                obj.delete(userInput, IDcounter);
            }
            else {
                if (userInput.equals("exit")) {
                } else {
                    System.out.println("\"" + userInput + "\" is not a valid command!");
                }
            }
        }
    }
}
