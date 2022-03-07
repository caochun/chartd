package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;

public class ApproveCommand extends BidCommand  {
    public ApproveCommand(Bid bid) {
        super(bid);
    }
}
