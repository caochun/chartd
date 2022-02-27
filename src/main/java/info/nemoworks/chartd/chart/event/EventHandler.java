package info.nemoworks.chartd.chart.event;

import com.google.common.eventbus.Subscribe;

public interface EventHandler<E extends ChartEvent> {

    @Subscribe
    void handle(E event);

}
