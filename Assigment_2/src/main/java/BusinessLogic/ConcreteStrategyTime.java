package BusinessLogic;

import DataModels.Server;
import DataModels.Task;

import java.util.List;

public class ConcreteStrategyTime implements  Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        int indexMin = 0;
        int index = 0;
        int minTime = Integer.MAX_VALUE;
        for(Server server: servers){
            if(server.getWaitingPeriod().get() < minTime){
                minTime = server.getWaitingPeriod().get();
                indexMin = index;
            }
            index++;
        }
        servers.get(indexMin).addTask(t);
    }
}
