package info.nemoworks.chartd.bid.message.query;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.NonNull;

public class ApprovingQuery extends BidQuery {
    public ApprovingQuery(@NonNull Bid bid) {
        super(bid);
    }
}
