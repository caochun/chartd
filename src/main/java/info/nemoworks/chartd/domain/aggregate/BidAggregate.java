package info.nemoworks.chartd.domain.aggregate;


import info.nemoworks.chartd.domain.command.*;
import info.nemoworks.chartd.domain.model.Bid;
import info.nemoworks.chartd.domain.model.BidAddon;
import info.nemoworks.chartd.domain.model.BidContent;
import info.nemoworks.chartd.domain.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidAggregate {

    private BidRepository bidRepository;

    @Autowired
    public BidAggregate(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Bid handleCreateCommand(CreateBidCommand command) {
        Bid bid = new Bid();
        bid.setTitle(command.getTitle());
        bid.setCreator(command.getCreator());
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleApproveCommand(ApproveBidCommand command) {
        Bid bid = bidRepository.getBid(command.getBidId());
        bid.setApproved(true);
        bidRepository.saveBid(bid);
        return bid;
    }


    public Bid handleCloseCommand(CloseBidCommand command) {
        Bid bid = bidRepository.getBid(command.getBidId());
        bid.setClosed(true);
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleEditContentCommand(EditBidContentCommand command) {
        Bid bid = bidRepository.getBid(command.getBidId());
        bid.setContent(new BidContent(command.getContent(), command.getAuthor()));
        bidRepository.saveBid(bid);
        return bid;
    }

    public Bid handleAppendAddonCommand(AppendBidAddonCommand command) {
        Bid bid = bidRepository.getBid(command.getBidId());
        bid.getAddons().add(new BidAddon(command.getBidId(), command.getMessage(), command.getAuthor()));
        bidRepository.saveBid(bid);
        return bid;
    }
}
