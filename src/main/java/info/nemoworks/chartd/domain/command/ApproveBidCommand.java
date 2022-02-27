package info.nemoworks.chartd.domain.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ApproveBidCommand {

    @NonNull
    private String bidId;

}
