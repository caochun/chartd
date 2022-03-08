package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Command;
import lombok.NonNull;

public class BidCommand extends Command<Bid> {
    public BidCommand(@NonNull Bid target, @NonNull Object source) {
        super(target,source);
    }
}
