package info.nemoworks.chartd.event;

import info.nemoworks.chartd.entity.BidAddon;

public class BidAddonAppendEvent extends Event {

    private BidAddon bidAddon;

    public BidAddonAppendEvent(BidAddon bidAddon) {
        this.bidAddon = bidAddon;
    }
}
