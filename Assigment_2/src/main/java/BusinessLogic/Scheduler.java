package BusinessLogic;
import java.util.ArrayList;
import java.util.List;
import DataModels.Server;
import DataModels.Task;


public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTaskPerServer;
    private Strategy strategy;

    public Scheduler (int maxNoServers, int maxTaskPerServer){
        this.maxNoServers = maxNoServers;
        this.maxTaskPerServer = maxTaskPerServer;
        servers = new ArrayList<Server>(maxNoServers);
        for(int i =0; i < maxNoServers; i++){
            Server server = new Server();
            servers.add(server);
            Thread thread = new Thread(servers.get(i));
            thread.start();
        }

    }

    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyTime();
        }
        else if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task task){
        strategy.addTask(servers, task);

    }

    public List<Server> getServers(){
        return servers;
    }

    public String toString() {
        String rezultat = "";
        int index = 1;
        for (Server server : servers) {
            rezultat += "Queue " + index + ": " + server.toString() + "\n";
            index++;
        }
        return rezultat;
    }

}
