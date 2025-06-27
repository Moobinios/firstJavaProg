import javax.swing.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    static int IDcounter = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("welcome to my program! type \"commands\" to see the available list of commands!!");
        String userInput = "";

        try {
            File file = new File("currentID.txt");
            Scanner reader = new Scanner(file);
            IDcounter = reader.nextInt();


        } catch (Exception ignored) {

        }
        while (!userInput.equals("exit")) {
            userInput = input.nextLine();
            if (userInput.equals("commands")) {
                System.out.println("these are the commands:\nadd\nview\ndelete\nexit");

            }


            if (userInput.startsWith("add")) {// remove the "add"
                userInput = userInput.replaceFirst("add", "");// remove the "add"
                userInput = userInput.trim();// remove the "add"
                try {
                    File currentID = new File("currentID.txt");
                    FileWriter writingOBJ = new FileWriter("currentID.txt");
                    writingOBJ.write(++IDcounter + "");
                    writingOBJ.close();
                    File files = new File(IDcounter + ".txt");
                    files.createNewFile();
                    FileWriter writer = new FileWriter(IDcounter + ".txt");
                    writer.write(userInput);
                    writer.close();
                } catch (java.io.IOException ignored) {
                }

            } else if (userInput.startsWith("view")) {
                userInput = userInput.replaceFirst("view", "");
                userInput = userInput.trim();
                // check if its empty, if so then show every single note.
                if (userInput.isEmpty()) {
                    int counter = 0;
                    try {
                        File read = new File("currentID.txt");
                        Scanner show = new Scanner(read);
                        counter = Integer.parseInt(show.nextLine());
                    } catch (java.io.FileNotFoundException ignored) {
                    }
                    for (int i = 1; i <= counter; i++) {
                        System.out.print("note " + i + " : ");
                        try {

                            File read = new File(i + ".txt");
                            if (!read.exists()) {
                                System.out.println("note " + i + " does not exist :(");

                            } else {
                                Scanner show = new Scanner(read);
                                System.out.println(show.nextLine());
                            }
                        } catch (java.io.FileNotFoundException ignored) {
                        }

                    }
                } else {
                    int noteID = Integer.parseInt(userInput);
                    try {
                        File getNoteById = new File(noteID + ".txt");
                        Scanner show = new Scanner(getNoteById);
                        String note = show.nextLine();
                        System.out.println(note);
                        show.close();

                    } catch (java.io.FileNotFoundException ignored) {
                    }
                }

            } else if (userInput.startsWith("delete")) {
                userInput = userInput.replaceFirst("delete", "");
                userInput = userInput.trim();
                int id = Integer.parseInt(userInput);
                File deleting = new File(id + ".txt");
                System.out.println(deleting.getAbsolutePath());
                System.out.println(deleting.exists());
                System.out.println(deleting.canWrite());

                if (deleting.delete()) {
                    System.out.println("note " + id + " deleted successfully!");
                }
            }
        }
    }
}
