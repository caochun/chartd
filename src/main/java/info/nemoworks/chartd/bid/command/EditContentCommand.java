package info.nemoworks.chartd.bid.command;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Command;
import lombok.Getter;
import lombok.NonNull;

public class EditContentCommand extends Command<Bid> {

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