package info.nemoworks.chartd.chart.event;


import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class EventDispatcher {

    private EventBus eventBus;

    private ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Autowired
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @PostConstruct
    public void resisterHandlers() {
        applicationContext.getBeansOfType(EventHandler.class).values().stream().forEach(eventHandler -> eventBus.register(eventHandler));
    }

    public void dispatch(Event event) {
        this.eventBus.post(event);
    }

}
