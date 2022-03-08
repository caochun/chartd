package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.domain.BidService;
import info.nemoworks.chartd.bid.message.query.BidQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
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
    public void register() {
        getStub().register(new Subscriber<>(bidService::handleCreateCommand));
    }


    public void pubQuery(BidQuery bidQuery) {
        if (null == bidQuery) return;
        else{
            getStub().pub(bidQuery);
        }
    }



}
