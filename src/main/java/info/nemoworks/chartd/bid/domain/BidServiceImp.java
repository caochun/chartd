package info.nemoworks.chartd.bid.domain;

import info.nemoworks.chartd.bid.actor.BidActor;
import info.nemoworks.chartd.bid.message.command.*;
import info.nemoworks.chartd.bid.message.query.ApprovingQuery;
import info.nemoworks.chartd.bid.message.query.CreatingQuery;
import info.nemoworks.chartd.bid.message.query.EditingQuery;
import info.nemoworks.chartd.bid.repository.BidRepository;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BidServiceImp implements BidService {


    @Autowired
    public void setBidRepository(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    private BidRepository bidRepository;

    private BidActor bidActor;

    @Autowired
    public void setBidActor(BidActor bidActor) {
        this.bidActor = bidActor;
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

//    @Override
//    public void handleCloseCommand(CloseCommand command) {
//        Bid bid = bidRepository.getBid(command.getTarget().getId());
//        bid.setClosed(true);
//        bidRepository.saveBid(bid);
//    }

//    @Override
//    public void handleEditContentCommand(EditContentCommand command) {
//        Bid bid = bidRepository.getBid(command.getTarget().getId());
//        bid.setContent(new Content(command.getContent(), command.getEditor()));
//        bidRepository.saveBid(bid);
//    }

//    @Override
//    public void handleAppendAddonCommand(AppendAddonCommand command) {
//        Bid bid = bidRepository.getBid(command.getTarget().getId());
//        bid.getAddons().add(new Addon(command.getTarget().getId(), command.getAddon(), command.getAuthor()));
//        bidRepository.saveBid(bid);
//    }

    @Override
    public CreatingQuery queryOnCreating(Bid bid) {
        return new CreatingQuery(bid);
    }

    @Override
    public EditingQuery queryOnEditing(Bid bid) {
        return new EditingQuery(bid);
    }

    @Override
    public ApprovingQuery queryOnApproving(Bid bid) {
        return new ApprovingQuery(bid);
    }



    @Override
    public void bootstrap() {
        Bid bid = new Bid();
        try {
            BidChart bidChart = new BidChart(bid, this::pubQuery);
        } catch (ModelException e) {
            e.printStackTrace();
        }
    }

    public void pubQuery(EnterableState state, Bid bid){
        switch (state.getId()){
            case "created":
                bidActor.pubQuery(new CreatingQuery(bid));
                break;
            case "editing":
                bidActor.pubQuery(new EditingQuery(bid));
                break;
            default:
                return;
        }

    }
}
