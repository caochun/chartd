package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Bid;
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
