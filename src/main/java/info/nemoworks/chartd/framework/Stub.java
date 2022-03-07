package info.nemoworks.chartd.framework;

import com.google.common.eventbus.EventBus;
import info.nemoworks.chartd.framework.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Stub {

    private EventBus eventBus;

    @Autowired
    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void pub(Message message){
        eventBus.post(message);
    }

    public void register(Object subscriber){
        eventBus.register(subscriber);
    }

}
