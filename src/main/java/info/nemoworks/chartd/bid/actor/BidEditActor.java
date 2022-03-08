package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.query.EditingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidEditActor extends Actor {

    private Map<String, EditingQuery> queries = new HashMap<>();

    @PostConstruct
    public void registerEditQueryMessageSubscriber(){
        this.register(this::handleEditingMessage);
    }

    public void handleEditingMessage(Message<EditingQuery> message) {
        this.queries.put(message.getPayload().getSource().getId(), message.getPayload());
    }

}
