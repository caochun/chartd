package info.nemoworks.chartd.domain.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateBidCommand {

    @NonNull
    private String title;

    private String creator;

}
