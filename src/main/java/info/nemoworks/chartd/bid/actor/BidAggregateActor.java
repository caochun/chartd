package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.bid.domain.BidAggregate;
import info.nemoworks.chartd.bid.domain.BidChart;
import info.nemoworks.chartd.bid.message.command.*;
import info.nemoworks.chartd.bid.message.query.BidQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BidAggregateActor extends Actor {

    private BidAggregate bidAggregate;

    @Autowired
    public void setBidAggregate(BidAggregate bidAggregate) {
        this.bidAggregate = bidAggregate;
    }

    @PostConstruct
    public void register() {
//        this.getStub().register(new Subscriber<CreateCommand>(bidAggregate::handleCreateCommand));
//        this.getStub().register(new Subscriber<ApproveCommand>(bidAggregate::handleApproveCommand));
//        this.getStub().register(new Subscriber<CloseCommand>(bidAggregate::handleCloseCommand));
//        this.getStub().register(new Subscriber<EditContentCommand>(bidAggregate::handleEditContentCommand));
//        this.getStub().register(new Subscriber<AppendAddonCommand>(bidAggregate::handleAppendAddonCommand));
    }


    public void pubQuery(EnterableState state, Bid bid) {

        BidQuery bidQuery;

        switch (state.getId()) {
            case BidQuery.APPROVING:
                bidQuery =  bidAggregate.queryOnApproving(bid);
                break;
            case BidQuery.CREATING:
                bidQuery = bidAggregate.queryOnCreating(bid);
                break;
            case BidQuery.EDITING:
                bidQuery = bidAggregate.queryOnEditing(bid);
                break;
            default:
                bidQuery = null;
        }

        if (null == bidQuery) return;
        else{
            getStub().pub(bidQuery);
        }

    }

    public void bootstrap() throws ModelException {
        Bid bid = new Bid();
        BidChart bidChart = new BidChart(bid, this::pubQuery);
    }

}
