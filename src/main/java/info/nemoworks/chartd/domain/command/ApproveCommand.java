package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Bid;

public class ApproveCommand extends Command<Bid> {
    public ApproveCommand(Bid bid) {
        super(bid);
    }
}
