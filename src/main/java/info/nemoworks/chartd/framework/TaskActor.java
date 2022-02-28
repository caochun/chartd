package info.nemoworks.chartd.framework;

import java.util.HashMap;
import java.util.Map;

public abstract class TaskActor<T extends Task, C> {

    private Map<String, Task> tasks = new HashMap<>();


    public void onReceive(T task) {
        tasks.put(task.getTarget().getId(), task);
    }

    public abstract Command process(T task, C context);
}
