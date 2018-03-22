/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;
import java.util.Date;
/**
 *
 * @author justin
 */
public class Model {
    
    int taskCount = 0;
    Task[] tasks = new Task[100];
    FileHelper helper = new FileHelper();
    
    Model() {
        // Constructor
    }
    
    void add(String title, String description){
        Task task = new Task();
        task.setDescription(description);
        task.setTitle(title);
        
        // add my task to the tasks array
        tasks[taskCount] = task;
        taskCount = taskCount + 1;
    }
    
    void remove(int index){
        // This is getting into SL IB Comp Sci level now...
        
        for (int i = index; i < taskCount; i = i + 1) {
            tasks[i] = tasks[i + 1];
        }
        
    }
    
    void edit(int index, String title, String description) {
        // how can we update the information of the
        // task at index?
        
        tasks[index].setDescription(description);
        tasks[index].setTitle(title);
    }
    
    String[] getTasks() {
        // Create a new string array
        String[] tmpTasks = new String[taskCount];
        // Loop through the tasks and add a string representation
        // of each one to the new array
        
        for (int i = 0;i < taskCount; i = i + 1) {
            // Assign a string representation if the ith task
            // to the ith element of tmpTasks
            tmpTasks[i] = tasks[i].toString();
        }
        // return the new array
        return tmpTasks;
    }
    
    String[] getTaskValues(int index) {
        String[] values = new String[2];
        values[0] = tasks[index].getTitle();
        values[1] = tasks[index].getDescription();
        return values;
    }
            
    
}
