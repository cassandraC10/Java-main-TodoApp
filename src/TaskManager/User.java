package TaskManager;

import Bank.Account;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;

    private List<Task> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<Task>();
    }

    public String getName() { return name; }

}
