package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.BidTask;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidCreateActor extends Actor {

    private Map<String, BidTask.Creating> tasks = new HashMap<>();


    @PostConstruct
    public void register() {
        this.getStub().register(new Subscriber<BidTask.Creating>(this::handleCreating));
    }

    public void handleCreating(BidTask.Creating task) {
        this.tasks.put(task.getSubject().getId(), task);
    }


}
