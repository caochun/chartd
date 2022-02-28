package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.command.ApproveCommand;
import info.nemoworks.chartd.framework.Command;
import info.nemoworks.chartd.framework.TaskActor;
import info.nemoworks.chartd.bid.task.BidTask;

public class BidApproveActor extends TaskActor<BidTask, Void> {
    @Override
    public Command process(BidTask task, Void context) {
        return new ApproveCommand(task.getTarget());
    }
}
