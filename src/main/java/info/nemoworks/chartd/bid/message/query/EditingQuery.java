package info.nemoworks.chartd.bid.message.query;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.NonNull;

public class EditingQuery extends BidQuery {
    public EditingQuery(@NonNull Bid bid) {
        super(bid);
    }
}
