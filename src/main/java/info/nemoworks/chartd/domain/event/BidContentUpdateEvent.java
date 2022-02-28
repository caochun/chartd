package info.nemoworks.chartd.domain.event;

import info.nemoworks.chartd.domain.model.Content;
import lombok.Getter;

public class BidContentUpdateEvent extends Event {

    @Getter
    private Content content;

    public BidContentUpdateEvent(Content content) {
        super("BidContentUpdateEvent");
        this.content = content;
    }
}
