package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class CreateCommand extends BidCommand {

    @Getter
    @NonNull
    private String title;

    @Getter
    private String creator;

    public CreateCommand(@NonNull Bid target, @NonNull Object source, @NonNull String title, String creator) {
        super(target, source);
        this.title = title;
        this.creator = creator;
    }
}
