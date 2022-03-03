package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.domain.BidChart;
import info.nemoworks.chartd.bid.domain.Addon;
import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.bid.domain.Content;
import info.nemoworks.chartd.bid.message.*;
import info.nemoworks.chartd.bid.repository.BidRepository;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Entity;
import info.nemoworks.chartd.framework.Subscriber;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BidAggregateActor extends Actor implements BidAggregate {


    private BidRepository bidRepository;

    @Autowired
    public BidAggregateActor(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public BidAggregateActor() {

    }

    @PostConstruct
    public void register(){
        this.getStub().register(new Subscriber<CreateCommand>(this::handleCreateCommand));
        this.getStub().register(new Subscriber<ApproveCommand>(this::handleApproveCommand));
        this.getStub().register(new Subscriber<CloseCommand>(this::handleCloseCommand));
        this.getStub().register(new Subscriber<EditContentCommand>(this::handleEditContentCommand));
        this.getStub().register(new Subscriber<AppendAddonCommand>(this::handleAppendAddonCommand));
    }

    @Override
    public void handleCreateCommand(CreateCommand command) {
        Bid bid = new Bid();
        bid.setTitle(command.getTitle());
        bid.setCreator(command.getCreator());
        bidRepository.saveBid(bid);
    }

    @Override
    public void handleApproveCommand(ApproveCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setApproved(true);
        bidRepository.saveBid(bid);
    }

    @Override
    public void handleCloseCommand(CloseCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setClosed(true);
        bidRepository.saveBid(bid);
    }

    @Override
    public void handleEditContentCommand(EditContentCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setContent(new Content(command.getContent(), command.getEditor()));
        bidRepository.saveBid(bid);
    }

    @Override
    public void handleAppendAddonCommand(AppendAddonCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.getAddons().add(new Addon(command.getTarget().getId(), command.getAddon(), command.getAuthor()));
        bidRepository.saveBid(bid);
    }

    public void pubState(EnterableState state, Entity bid) {
        getStub().pub(BidTask.fromTaskName(state.getId(), (Bid) bid));
    }

    public void bootstrap() throws ModelException {
        Bid bid = new Bid();
        BidChart bidChart = new BidChart(bid, this::pubState);
    }

}
