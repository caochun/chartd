package info.nemoworks.chartd.bid.aggregate;


import info.nemoworks.chartd.bid.command.*;
import info.nemoworks.chartd.domain.command.*;
import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.bid.domain.Addon;
import info.nemoworks.chartd.bid.domain.Content;
import info.nemoworks.chartd.bid.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BidAggregate {

    private BidRepository bidRepository;

    @Autowired
    public BidAggregate(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid handleCreateCommand(CreateCommand command) {
        Bid bid = new Bid();
        bid.setTitle(command.getTitle());
        bid.setCreator(command.getCreator());
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleApproveCommand(ApproveCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setApproved(true);
        bidRepository.saveBid(bid);
        return bid;
    }


    public Bid handleCloseCommand(CloseCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setClosed(true);
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleEditContentCommand(EditContentCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.setContent(new Content(command.getContent(), command.getEditor()));
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleAppendAddonCommand(AppendAddonCommand command) {
        Bid bid = bidRepository.getBid(command.getTarget().getId());
        bid.getAddons().add(new Addon(command.getTarget().getId(), command.getAddon(), command.getAuthor()));
        bidRepository.saveBid(bid);
        return bid;
    }
}
