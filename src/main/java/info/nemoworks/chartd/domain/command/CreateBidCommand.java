package info.nemoworks.chartd.domain.command;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateBidCommand {

    @NonNull
    private String title;

    private String creator;

}
