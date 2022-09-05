package TaskManager;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoAppTest {
    @Test
    public void createTodoApp(){
        ToDoApp cassandra = new ToDoApp("Cassandra");
        assertInstanceOf(ToDoApp.class, cassandra);
        assertNotNull(cassandra);
    }

    @Test
    public void taskCanBeAddedInTodoApp(){
        ToDoApp cassandra = new ToDoApp("Cassandra");
        Task task1 = new Task("learn OOP");
        Task task2 = new Task("learn Methods");
        Task task3 = new Task("learn Maven");
        Task task4 = new Task("learn SpringBoot");
        cassandra.addTask(task1);
        cassandra.addTask(task2);
        cassandra.addTask(task3);
        cassandra.addTask(task4);
        assertEquals(4, cassandra.getNumberOfTasks());
    }

    @Test
    public void taskCanBeFoundTest(){
        ToDoApp cassandra = new ToDoApp("Cassandra");
        Task task1 = new Task("learn OOP");
        Task task2 = new Task("learn Methods");
        Task task3 = new Task("learn Maven");
        Task task4 = new Task("learn SpringBoot");
        cassandra.addTask(task1);
        cassandra.addTask(task2);
        cassandra.addTask(task3);
        cassandra.addTask(task4);
//        cassandra.findTask();

        cassandra.searchTask("learn Maven");
        assertEquals(4, cassandra.getNumberOfTasks());
    }


    @Test
    public void TaskCanBeDeleted(){
        ToDoApp cassandra = new ToDoApp("Cassandra");
        Task task1 = new Task("learn OOP");
        Task task2 = new Task("learn Methods");
        Task task3 = new Task("learn Maven");
        Task task4 = new Task("learn SpringBoot");
        cassandra.addTask(task1);
        cassandra.addTask(task2);
        cassandra.addTask(task3);
        cassandra.addTask(task4);
        cassandra.deleteTask("learn Methods");
        assertEquals(3, cassandra.getNumberOfTasks());
    }
}