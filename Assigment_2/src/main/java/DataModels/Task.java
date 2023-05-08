package DataModels;

public class Task implements Comparable<Task> {
    private int arrivalTime;
    private int serviceTime;

    public Task(int arrivalTime, int serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return "T{" + "AT=" + arrivalTime + ", ST=" + serviceTime + '}';
    }

    public int compareTo(Task task){
        if(task.arrivalTime < this.getArrivalTime()){
            return 1;
        }
        else {
            if (task.arrivalTime == this.getArrivalTime()) {
                return 0;
            } else {
                return -1;
            }
        }
    }


}
