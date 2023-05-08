package BusinessLogic;

import DataModels.Server;
import DataModels.Task;
import View.Interfata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable {
    private int maxArrivalTime;
    private int minArrivalTime;
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler;

    private ArrayList<Task> generatedTask;

    private Interfata view;

    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int minArrivalTime, int maxArrivalTime, int numberOfServers, int numberOfClients, Interfata view) {
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;
        this.numberOfServers = numberOfServers;
        this.numberOfClients = numberOfClients;
        generatedTask = new ArrayList<>();
        scheduler = new Scheduler(numberOfServers, numberOfClients);
        this.view = view;
        generateRandomTasks();
    }

    private void generateRandomTasks() {

        for (int i = 0; i < numberOfClients; i++) {
            int randomArrival = (int) (Math.random() * (maxArrivalTime - minArrivalTime)) + minArrivalTime;
            int randomService = (int) (Math.random() * (maxProcessingTime - minProcessingTime)) + minProcessingTime;
            Task task = new Task(randomArrival, randomService);
            generatedTask.add(task);
            //task.toString();
        }

        Collections.sort(generatedTask);
    }

    public void run() {
        int currentTime = 1;
        float serviceTime = 0;
        float sumOfPeriods = 0;
        float averageWaitingTime = 0;
        int peakTime = 0;
        int peakTasks= 0;
        int sumOfTasks = 0;
        String result = "";
        try {
            for (Task task : generatedTask) {
                serviceTime += task.getServiceTime();
            }
            serviceTime /= (numberOfClients);
            while (currentTime <= timeLimit) {
                if (!generatedTask.isEmpty()) {
                    for (int i = 0; i < numberOfClients; i++) {
                        if (generatedTask.size() > 0 && generatedTask.get(0).getArrivalTime()==currentTime) {
                            scheduler.changeStrategy(selectionPolicy);
                            scheduler.dispatchTask(generatedTask.get(0));
                            generatedTask.remove(0);
                        }
                    }

                }
                //System.out.println("Current time: " + currentTime);
                String waitingTasks = "Current time: " + currentTime + "\nWaiting tasks: ";
                for (Task task : generatedTask) {
                    waitingTasks += task.toString() + ", ";
                }
                result = waitingTasks + " \n" + scheduler.toString() + "\n";
                System.out.println(result);
                if (view != null) {
                    view.updateResultArea(result);
                }
                sumOfTasks = 0;
                for(Server s: scheduler.getServers()) {
                    sumOfTasks += s.getTasks().size();
                    sumOfPeriods += s.getWaitingPeriod().get();
                }
                averageWaitingTime = sumOfPeriods / (numberOfServers * timeLimit);
                if(peakTasks < sumOfTasks){
                    peakTasks = sumOfTasks;
                    peakTime = currentTime;
                }
                currentTime++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        if (view != null) {
            view.updateAvgServiceTime(serviceTime);
            view.updateAvgWaitingTime(averageWaitingTime);
            view.updatePeakHour(peakTime, " nr tasks: ", peakTasks);
        }
        WriteInFolder();

    }



    public void WriteInFolder() {
        try {
            FileWriter fileWriter = new FileWriter("simulari.txt");
            fileWriter.write(this.view.resultArea.getText());
            fileWriter.write(this.view.avgWT.getText());
            fileWriter.write(this.view.avgST.getText());
            fileWriter.write(this.view.peakH.getText());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}



