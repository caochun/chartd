package info.nemoworks.chartd.bid.message;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Command;

public class ApproveCommand extends Command<Bid> {
    public ApproveCommand(Bid bid) {
        super(bid);
    }
}
