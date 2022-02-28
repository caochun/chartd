package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.framework.Command;
import info.nemoworks.chartd.bid.command.EditContentCommand;
import info.nemoworks.chartd.framework.TaskActor;
import info.nemoworks.chartd.bid.task.BidTask;
import org.javatuples.Pair;

public class BidEditActor extends TaskActor<BidTask, Pair<String, String>> {
    @Override
    public Command process(BidTask task, Pair<String, String> context) {
        return new EditContentCommand(task.getTarget(), context.getValue0(), context.getValue1());
    }
}
