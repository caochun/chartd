package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;

public class CloseCommand extends BidCommand {
    private String closer;

    public CloseCommand(Bid bid, String closer) {
        super(bid);
        this.closer = closer;
    }
}