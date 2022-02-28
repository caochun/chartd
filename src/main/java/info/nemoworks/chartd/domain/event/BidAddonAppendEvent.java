package info.nemoworks.chartd.domain.event;

import info.nemoworks.chartd.domain.model.Addon;

public class BidAddonAppendEvent extends Event {

    private Addon addon;

    public BidAddonAppendEvent(Addon addon) {
        super("BidAddonAppendEvent");
        this.addon = addon;
    }
}
