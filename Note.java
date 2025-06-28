import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Note {
//    static int IDcounter = 0;

    File file = new File("currentID.txt");

    public void add(String note, int c) {
        if (note.startsWith("add")) {// remove the "add"
            note = note.replaceFirst("add", "");// remove the "add"
            note = note.trim();// remove the "add"
            try {
                FileWriter writingOBJ = new FileWriter("currentID.txt");
                writingOBJ.write(++c + "");
                writingOBJ.close();
                File files = new File(c + ".txt");
                if (files.createNewFile()) {
                    System.out.println("note added successfully!");
                }
                FileWriter writer = new FileWriter(c + ".txt");
                writer.write(note);
                writer.close();
            } catch (java.io.IOException ignored) {
            }
        }

    }

    public void view(String note, int c) {
        if (note.startsWith("view")) {
            note = note.replaceFirst("view", "");
            note = note.trim();
            // check if its empty, if so then show every single note.
            if (note.isEmpty()) {
                int counter = 0;
                try {

                    Scanner show = new Scanner(file);
                    counter = Integer.parseInt(show.nextLine());
                    show.close();
                } catch (java.io.FileNotFoundException ignored) {
                }
                System.out.println("here are all the notes: ");
                for (int i = 1; i <= counter; i++) {

                    try {

                        File read = new File(i + ".txt");
                        if (!read.exists()) {
                        } else {
                            System.out.print("note " + i + " : ");
                            Scanner show = new Scanner(read);
                            System.out.println(show.nextLine());
                            show.close();
                        }
                    } catch (java.io.FileNotFoundException ignored) {
                    }

                }
            } else {
                int noteID = Integer.parseInt(note);
                try {
                    File getNoteById = new File(noteID + ".txt");
                    Scanner show = new Scanner(getNoteById);
                    System.out.println("note " + noteID + " : " + show.nextLine());
                    show.close();

                } catch (java.io.FileNotFoundException ignored) {
                }
            }

        }
    }

    public void delete(String note, int c) {
        if (note.startsWith("delete")) {
            note = note.replaceFirst("delete", "");
            note = note.trim();
            int id = Integer.parseInt(note);
            File deleting = new File(id + ".txt");
            if (deleting.delete()) {
                System.out.println("note " + id + " deleted successfully!");
            }
        }
    }
}
