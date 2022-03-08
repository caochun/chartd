package info.nemoworks.chartd.bid.message.query;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Query;
import lombok.NonNull;

public class BidQuery extends Query<Bid> {

    public BidQuery(@NonNull Bid bid) {
        super(bid);
    }

    public static final String APPROVING = "approve";
    public static final String EDITING = "editing";
    public static final String CREATING = "created";

}
