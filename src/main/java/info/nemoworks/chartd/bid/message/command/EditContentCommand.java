package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class EditContentCommand extends BidCommand {

    @Getter
    @NonNull
    private String content;

    @Getter
    private String editor;

    public EditContentCommand(@NonNull Bid target, @NonNull String content, String editor) {
        super(target);
        this.content = content;
        this.editor = editor;
    }
}