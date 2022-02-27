package info.nemoworks.chartd.domain.event;

import info.nemoworks.chartd.domain.model.BidContent;
import lombok.Getter;

public class BidContentUpdateEvent extends Event {

    @Getter
    private BidContent bidContent;

    public BidContentUpdateEvent(BidContent bidContent) {
        super("BidContentUpdateEvent");
        this.bidContent = bidContent;
    }
}
