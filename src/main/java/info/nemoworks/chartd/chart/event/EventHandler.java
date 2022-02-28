package info.nemoworks.chartd.chart.event;

import com.google.common.eventbus.Subscribe;

public interface EventHandler<T extends Event> {

    @Subscribe
    void handle(T event);

}
