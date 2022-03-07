package info.nemoworks.chartd.bid.message.query;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.NonNull;

public class CreatingQuery extends BidQuery {

    public CreatingQuery(@NonNull Bid target) {
        super(target, "created");
    }
}
