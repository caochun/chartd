package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.domain.BidService;
import info.nemoworks.chartd.bid.message.command.CreateCommand;
import info.nemoworks.chartd.bid.message.query.BidQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BidActor extends Actor {

    private BidService bidService;

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @PostConstruct
    public void registerCommandSubscribers() {
        super.<Message<CreateCommand>>register(this::handleCreateCommandMessage);
    }

    private void handleCreateCommandMessage(Message<CreateCommand> message) {
        this.bidService.handleCreateCommand(message.getPayload());
    }

    public void pubQueryMessage(BidQuery bidQuery) {
        if (null == bidQuery) return;
        else {
            pub(new Message<>(this, bidQuery));
        }
    }
}
