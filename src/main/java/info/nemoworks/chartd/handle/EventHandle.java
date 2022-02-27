package info.nemoworks.chartd.handle;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import info.nemoworks.chartd.event.Event;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EventHandle {

    private EventBus eventBus;

//    @Autowired
//
//    @Subscribe
//    private void handle(T event) {
//        LoggerFactory.getLogger(this.getClass()).info("Handling " + event.getEventString());
//    }

}
