package info.nemoworks.chartd.bid.message;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Command;
import lombok.*;

public class CreateCommand extends Command<Bid> {

    @Getter
    @NonNull
    private String title;

    @Getter
    private String creator;

    public CreateCommand(@NonNull Bid target, @NonNull String title, String creator) {
        super(target);
        this.title = title;
        this.creator = creator;
    }
}
