package info.nemoworks.chartd.bid.event;

import info.nemoworks.chartd.bid.domain.Content;
import lombok.Getter;

public class BidContentUpdateEvent extends Event {

    @Getter
    private Content content;

    public BidContentUpdateEvent(Content content) {
        super("BidContentUpdateEvent");
        this.content = content;
    }
}
