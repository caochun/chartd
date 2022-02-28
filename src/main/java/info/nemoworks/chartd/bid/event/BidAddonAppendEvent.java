package info.nemoworks.chartd.bid.event;

import info.nemoworks.chartd.bid.domain.Addon;

public class BidAddonAppendEvent extends Event {

    private Addon addon;

    public BidAddonAppendEvent(Addon addon) {
        super("BidAddonAppendEvent");
        this.addon = addon;
    }
}
