import java.util.*;

import implementations.Queue;

class Task {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

}

public class TaskScheduler {
    private Queue<Task> taskQueue;

    public TaskScheduler() {
        this.taskQueue = new Queue<>();
    }

    public void addTask(Task task) {
        taskQueue.offer(task);
    }

    public void executeTasks() {
        while (!taskQueue.isEmpty()) {
            System.out.println("Executing Task: " + taskQueue.poll().getTaskName());
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Task task4 = new Task( "Task 4");
        Task task5 = new Task( "Task 5");

        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);
        scheduler.addTask(task4);
        scheduler.addTask(task5);

        System.out.println("Execute Tasks:");
        scheduler.executeTasks();
    }
}
