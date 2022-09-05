package TaskManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToDoApp {
    private List<User> users;
//    private  String name;
    private Set<Task> tasks;


    public ToDoApp() {
        users = new ArrayList<User>();
        tasks = new HashSet<>();
    }
    public ToDoApp(String name) {
        tasks = new HashSet<>();
    }

    public User createUser(String user){return new User(user); }
    public void addUser(User user) {
        users.add(user);
    }


//    public String getName() { return name; }


    public Task createTask(String title){ return new Task(title); }
    public void addTask(Task task) {tasks.add(task); }

    public void updateTask(Task task, String title) {
        task.setTask(title);
        tasks.add(task);
    }
//    public void updateTask(Task task) {tasks.add(task); }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void findTask() {
        for (Task task : tasks) {
            System.out.println(task.getTask());
            System.out.println("***************");
        }
    }

    public Task searchTask(String title) {
        for (Task task:tasks) {
            if (title.equalsIgnoreCase(task.getTask())){
                return task;
            }
        }
        return null;
    }
    public boolean deleteTask(String title) {
        for (Task task : tasks) {
            if (title.equals(task.getTask())) {
                tasks.remove(task);
                return true;
            }
        }
        return  false;
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    //    public void setNewUser(String newUser) {
//        this.name = newUser;
//    }

    public boolean isNameValid(String name) {
        for (User user:users) {
            if (name.equals(user.getName())) return true;
        }
        return false;
    }


}
