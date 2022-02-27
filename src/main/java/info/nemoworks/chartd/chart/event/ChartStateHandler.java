package info.nemoworks.chartd.chart.event;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ChartStateHandler implements EventHandler<ChartStateEvent> {

    private EventBus eventBus;

    @Autowired
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void postBack(ChartTransitionEvent chartTransitionEvent) {
        eventBus.post(chartTransitionEvent);
    }

    @Override
    public abstract void handle(ChartStateEvent event);

}
