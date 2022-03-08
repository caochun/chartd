package info.nemoworks.chartd.bid.domain;

import info.nemoworks.chartd.bid.message.command.*;
import info.nemoworks.chartd.bid.message.query.ApprovingQuery;
import info.nemoworks.chartd.bid.message.query.CreatingQuery;
import info.nemoworks.chartd.bid.message.query.EditingQuery;


public interface BidService {

    public void handleCreateCommand(CreateCommand command);

    public void handleApproveCommand(ApproveCommand command);

//    public void handleCloseCommand(CloseCommand command);

//    public void handleEditContentCommand(EditContentCommand command);

//    public void handleAppendAddonCommand(AppendAddonCommand command);

    public CreatingQuery queryOnCreating(Bid bid);

    public EditingQuery queryOnEditing(Bid bid);

    public ApprovingQuery queryOnApproving(Bid bid);

    public void bootstrap();
}
