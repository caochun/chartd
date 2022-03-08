package info.nemoworks.chartd.bid.message.command;

import info.nemoworks.chartd.bid.domain.Bid;
import lombok.Getter;
import lombok.NonNull;

public class ApproveCommand extends BidCommand {

    @Getter
    private String approver;

    public ApproveCommand(@NonNull Bid bid, String approver) {
        super(bid);
        this.approver = approver;
    }
}
