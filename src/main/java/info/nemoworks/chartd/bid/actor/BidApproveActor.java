package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.BidTask;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BidApproveActor extends Actor {
    private Map<String, BidTask.Approving> tasks = new HashMap<>();

    public BidApproveActor() {
        this.getStub().register(new Subscriber<BidTask.Approving>(this::handleApproving));
    }

    public void handleApproving(BidTask.Approving task) {
        this.tasks.put(task.getSubject().getId(), task);
    }
}
