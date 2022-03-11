package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.command.CreateCommand;
import info.nemoworks.chartd.bid.message.query.CreatingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Message;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidCreateActor extends Actor {

    private Map<String, CreatingQuery> queries = new HashMap<>();


    @PostConstruct
    public void registerQuerySubscriber() {
        super.register(this::handleCreatingQueryMessage);
    }

    private void handleCreatingQueryMessage(Message<CreatingQuery> message) {
        LoggerFactory.getLogger(BidCreateActor.class).info("handling bid " + message.getPayload().getSource().getId());
        this.handleCreating(message.getPayload());
    }

    public void handleCreating(CreatingQuery query) {
        this.queries.put(query.getSource().getId(), query);
    }

    public void pubCreateCommandMessage() {
        queries.values().stream().forEach(creatingQuery -> {
            this.pub(new Message<CreateCommand>(this, new CreateCommand(creatingQuery.getSource(), "abc", this.toString())));
        });

    }


}
