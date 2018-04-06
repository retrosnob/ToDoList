/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Arrays;

public class FileHelper {

    // This class helps us to read and write stuff
    // from/to the disk.
    final String FILE_NAME = "tasks.sdv";
    BufferedReader reader;
    PrintWriter writer;

    public FileHelper() {
        
    }
    
    public static void main(String[] args) {
        System.out.println("Testing my file helper class...");
        FileHelper f = new FileHelper();
        String[] lines = f.readTasks();
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);            
        }
    }

    String[] readTasks() {
        String[] tasks = new String[100];
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            while (line != null) {
                tasks[count] = line;
                count = count + 1;
                line = reader.readLine();
            }
        } catch (FileNotFoundException f) {
            System.out.print("Tasks file not found");
        } catch (IOException i) {
            System.out.print("Cannot read from tasks file");

        }
        return Arrays.copyOfRange(tasks, 0, count);
    }

    void writeTasks(String[] lines) {
        try {
            writer = new PrintWriter(new FileWriter(FILE_NAME));
            
            for (int i = 0; i < lines.length; i++) {
                writer.println(lines[i]);
            }
            writer.close();
            
        } catch (IOException i) {
            System.out.print("Cannot open tasks file for output");
        }
    }

}
