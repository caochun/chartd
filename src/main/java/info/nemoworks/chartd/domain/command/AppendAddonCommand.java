package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Bid;
import lombok.Getter;
import lombok.NonNull;

public class AppendAddonCommand extends Command<Bid> {

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
