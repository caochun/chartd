package info.nemoworks.chartd.domain.event;

import info.nemoworks.chartd.domain.model.BidAddon;

public class BidAddonAppendEvent extends Event {

    private BidAddon bidAddon;

    public BidAddonAppendEvent(BidAddon bidAddon) {
        super("BidAddonAppendEvent");
        this.bidAddon = bidAddon;
    }
}
