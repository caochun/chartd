package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.BidTask;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BidEditActor extends Actor {

    private Map<String, BidTask.Editing> tasks = new HashMap<>();

    public BidEditActor() {
        this.getStub().register(new Subscriber<BidTask.Editing>(this::handleEditing));
    }

    public void handleEditing(BidTask.Editing task) {
        this.tasks.put(task.getSubject().getId(), task);
    }

}
