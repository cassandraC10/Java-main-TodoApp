package TaskManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoMain {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private ToDoApp toDoApp = new ToDoApp();

    public static void main(String[] args) {
        ToDoMain main = new ToDoMain();
        main.mainMenu();
        main.runToDoApp();
    }
    private void mainMenu() {
        try {
            for (int i = 0; i != -1; i++) {
                System.out.println("""
                     TASK MANAGER
                        Create a Todo List
                        Press
                        1. --> SIGN UP.
                        2. --> SIGN IN.
                        3. --> exit.
                        """);
                int response = keyboardInput.nextInt();
                keyboardInput.nextLine();
                switch (response) {
                    case 1 -> signUp();
                    case 2 -> signIn();
                    case 3 -> {
                        System.out.println("Thank you for using Task Manager");
                        mainMenu();
                    }
                    default -> { mainMenu();}
                }
            }
    } catch (
    InputMismatchException e) {
        throw new IllegalStateException("Unexpected entry"); }
                }

    private  void signUp() {
        String space = " ";

        System.out.println("Create a username: ");
        String userName = keyboardInput.nextLine();

        if (userName.contains(space)) {
            System.out.println("Invalid name");
            signUp();
        } else {
            toDoApp.getUsers().add(new User(userName));
            System.out.println("Congratulations " + userName.toUpperCase() + " You are registered successfully");
        }
    }

    private void signIn() {
        System.out.println("Enter your username to log in: ");
        String name = keyboardInput.nextLine();

        if (toDoApp.isNameValid(name)){
            System.out.println("Welcome " + name.toUpperCase() + ", You have been logged in successfully");
            runToDoAppSystem();
        } else {
            System.out.println("Invalid log in details, please try again");
            signIn();
        }
    }

    private void signOut(){
        System.out.println("You have successfully logged out");
        System.out.println();
        System.out.println();
        mainMenu();
    }

    private void runToDoApp() {
        System.out.println("TASK MANAGER");
        System.out.println("Enter your name: ");
        String name = keyboardInput.nextLine();

        toDoApp = new ToDoApp(name);

        if (toDoApp.isNameValid(name)) {
            runToDoApp();
        } else {
            System.out.println("What is your Name?: ");
            runToDoAppSystem();
        }
    }

    private void runToDoAppSystem() {
        boolean quit = false;
        while (!quit) {
            String prompt = """
                    Enter
                    1. -> Create task
                    2. -> Update Task
                    3. -> Search Task
                    4. -> view all Task
                    5. -> Delete Task
                    6. -> Sign Out
                    """;
            System.out.println(prompt);
            int userResponse = keyboardInput.nextInt();
            keyboardInput.nextLine();
            switch (userResponse) {
                case 1 -> createTask();
                case 2 -> updateTask();
                case 3 -> searchTask();
                case 4 -> viewAllTask();
                case 5 -> deleteTask();
                case 6 -> signOut();
                case 7 -> {
                    quit = true;
                }

                default -> runToDoAppSystem();
            }
        }
    }

    private void searchTask() {
        System.out.println("Input task to find: ");
        String title = keyboardInput.nextLine();

        Task foundTask = toDoApp.searchTask(title);
        if (foundTask!=null) System.out.println(foundTask);
        else System.out.println("Task not found!");
    }

    private void createTask() {
        System.out.println("Create a task: ");
        String title = keyboardInput.nextLine();

        Task task = toDoApp.createTask(title);
        toDoApp.addTask(task);
        System.out.println(task + " has been successfully added");
    }
    private void updateTask() {
        System.out.println("enter task to be updated: ");
        String userInputedTask = keyboardInput.nextLine();

        System.out.println("Update task: ");
        String title = keyboardInput.nextLine();

        Task task = toDoApp.searchTask(userInputedTask);
        System.out.println("found task----> " + task);
        toDoApp.updateTask(task, title);
        System.out.println(task + " has been updated ");
    }
//    private void viewAllTask() { toDoApp.findTask();}
    private void viewAllTask() { toDoApp.findTask();}
    private void deleteTask() {
        System.out.println("Enter a task : ");
        String title = keyboardInput.nextLine();

        if(toDoApp.deleteTask(title)){
            System.out.println("Task deleted");
        }
        else System.out.println("Task not found!");
    }


}
