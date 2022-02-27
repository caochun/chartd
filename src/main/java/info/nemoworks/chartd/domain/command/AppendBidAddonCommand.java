package info.nemoworks.chartd.domain.command;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AppendBidAddonCommand {

    @NonNull
    private String bidId;

    @NonNull
    private String message;

    private String author;
}
