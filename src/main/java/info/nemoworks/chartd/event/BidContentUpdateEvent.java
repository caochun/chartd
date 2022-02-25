package info.nemoworks.chartd.event;

import info.nemoworks.chartd.entity.BidContent;
import lombok.Getter;

public class BidContentUpdateEvent extends Event {

    @Getter
    private BidContent bidContent;

    public BidContentUpdateEvent(BidContent bidContent) {
        this.bidContent = bidContent;
    }
}
