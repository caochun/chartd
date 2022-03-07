package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.query.EditingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BidEditActor extends Actor {

    private Map<String, EditingQuery> queries = new HashMap<>();

    public BidEditActor() {
        this.getStub().register(new Subscriber<EditingQuery>(this::handleEditing));
    }

    public void handleEditing(EditingQuery query) {
        this.queries.put(query.getSubject().getId(), query);
    }

}
