package sample.models;

public class Task {
    private long dateCreated;
    private String task;
    private String description;

    public Task(long dateCreated, String task, String description) {
        this.dateCreated = dateCreated;
        this.task = task;
        this.description = description;
    }

    public Task() {
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
