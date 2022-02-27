package info.nemoworks.chartd.handle;

import com.google.common.eventbus.Subscribe;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StringHandle extends EventHandle{

    @Subscribe
    public void stringHandle(String state) {
        LoggerFactory.getLogger(StringHandle.class).info(state);
    }
}
