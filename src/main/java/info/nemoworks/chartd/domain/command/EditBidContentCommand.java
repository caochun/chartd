package info.nemoworks.chartd.domain.command;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EditBidContentCommand {

    @NonNull
    private String bidId;

    @NonNull
    private String content;

    private String author;
}
