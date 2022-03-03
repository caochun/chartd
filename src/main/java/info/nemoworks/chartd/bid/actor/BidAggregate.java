package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.*;

public interface BidAggregate {

    public void handleCreateCommand(CreateCommand command);

    public void handleApproveCommand(ApproveCommand command);

    public void handleCloseCommand(CloseCommand command);

    public void handleEditContentCommand(EditContentCommand command);

    public void handleAppendAddonCommand(AppendAddonCommand command);
}
