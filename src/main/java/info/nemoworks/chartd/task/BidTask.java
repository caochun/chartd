package info.nemoworks.chartd.task;

import info.nemoworks.chartd.domain.model.Bid;
import lombok.NonNull;
import org.apache.commons.scxml2.model.EnterableState;

public class BidTask extends Task<Bid> {
    public BidTask(@NonNull Bid target, @NonNull String task) {
        super(target, task);
    }

    public static BidTask fromState(EnterableState s, Bid bid) {
        return new BidTask(bid, s.getId());
    }
}
