package info.nemoworks.chartd.framework;

import java.util.HashMap;
import java.util.Map;

public interface TaskActor<T extends Task, C> {



    public void onReceive(T task) {
    }

    public abstract Command process(T task, C context);
}
