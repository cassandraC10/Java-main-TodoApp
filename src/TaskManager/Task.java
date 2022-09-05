package TaskManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private String task;
    private final LocalDateTime time;

    public Task(String task) {
        this.task = task;
        time = LocalDateTime.now();
    }

    public String getTask() {return task; }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd-MM-yyyy, hh:mm a");
        return dateTimeFormatter.format(this.time);
    }

    @Override
    public String toString() {
        return "Task{" +
                "task= "+task+
                " time=" + time +
                '}';
    }

}
