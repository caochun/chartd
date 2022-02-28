package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Bid;

public class CloseCommand extends Command<Bid> {
    public CloseCommand(Bid bid) {
        super(bid);
    }
}