package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class AppendAddonCommand extends BidCommand {

    @Getter
    @NonNull
    private String addon;

    @Getter
    private String author;

    public AppendAddonCommand(@NonNull Bid target, @NonNull String addon, String author) {
        super(target);
        this.addon = addon;
        this.author = author;
    }
}
