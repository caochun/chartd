package info.nemoworks.chartd.bid.message;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Command;

public class CloseCommand extends Command<Bid> {
    public CloseCommand(Bid bid) {
        super(bid);
    }
}