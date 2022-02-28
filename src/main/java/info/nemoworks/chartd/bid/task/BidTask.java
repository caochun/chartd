package info.nemoworks.chartd.bid.task;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Task;
import lombok.NonNull;
import org.apache.commons.scxml2.model.EnterableState;

public class BidTask extends Task<Bid> {
    public BidTask(@NonNull Bid target, @NonNull String task) {
        super(target, task);
    }

    private static final String TASK_CREATED_STATE = "created";
    private static final String TASK_EDITING_STATE = "editing";


    public static class CreatedStateTask extends BidTask {


        public CreatedStateTask(@NonNull Bid target) {
            super(target, TASK_CREATED_STATE);
        }
    }

    public static class EditingStateTask extends BidTask {


        public EditingStateTask(@NonNull Bid target) {
            super(target, TASK_EDITING_STATE);
        }
    }

    public static BidTask fromState(EnterableState s, Bid bid) {

        switch (s.getId()) {
            case TASK_CREATED_STATE:
                return new CreatedStateTask(bid);
            case TASK_EDITING_STATE:
                return new EditingStateTask(bid);
            default:
                return null;
        }

    }
}
