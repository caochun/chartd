package info.nemoworks.chartd.domain.command;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CloseBidCommand {

    @NonNull
    private String bidId;
}
