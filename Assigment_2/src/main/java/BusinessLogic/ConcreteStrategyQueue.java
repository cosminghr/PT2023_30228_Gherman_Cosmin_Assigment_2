package BusinessLogic;

import DataModels.Server;
import DataModels.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{

    public void addTask(List<Server> servers, Task t){
        int minQueue = Integer.MAX_VALUE;
        int index = 0;
        int indexS = 0;
        for(Server server: servers){
            if(server.getTasks().size() < minQueue){
                indexS = index;
                minQueue = server.getTasks().size();
            }
            index++;
        }
        servers.get(indexS).addTask(t);
    }
}
