package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Bid;
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