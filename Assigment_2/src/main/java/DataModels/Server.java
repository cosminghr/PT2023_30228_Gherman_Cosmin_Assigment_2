package DataModels;

import DataModels.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server() {
        tasks = new LinkedBlockingQueue<>();
        waitingPeriod = new AtomicInteger(0);
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void addTask(Task newTask) {
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public void run() {
        while (true) {
            if (tasks.size() != 0) {
                Task aux = this.tasks.peek();
                try {
                    Thread.sleep(aux.getServiceTime() * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.tasks.remove();
                this.waitingPeriod.set(waitingPeriod.get() - aux.getServiceTime());
            }

        }
    }

    public String toString() {
        if (tasks.size() == 0)
            return "Close";
        return "Tasks=" + tasks;
    }

}
