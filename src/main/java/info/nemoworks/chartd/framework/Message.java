package info.nemoworks.chartd.framework;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class Message extends ApplicationEvent {

    @Getter
    private final UUID id = UUID.randomUUID();

    public Message(Object source) {
        super(source);
    }

}
