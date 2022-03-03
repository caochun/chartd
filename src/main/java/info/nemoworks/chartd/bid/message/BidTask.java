package info.nemoworks.chartd.bid.message;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.Task;
import lombok.NonNull;

public class BidTask extends Task<Bid> {
    public BidTask(@NonNull Bid target, @NonNull String task) {
        super(target, task);
    }

    public static final String TASK_CREATED_STATE = "created";
    public static final String TASK_EDITING_STATE = "editing";
    public static final String TASK_APPROVE_STATE = "approve";


    public static class Creating extends BidTask {


        public Creating(@NonNull Bid target) {
            super(target, TASK_CREATED_STATE);
        }
    }

    public static class Editing extends BidTask {
        public Editing(@NonNull Bid target) {
            super(target, TASK_EDITING_STATE);
        }
    }

    public static class Approving extends BidTask {
        public Approving(@NonNull Bid target) {
            super(target, TASK_APPROVE_STATE);
        }
    }

    public static BidTask fromTaskName(String task, Bid bid) {
        switch (task) {
            case TASK_CREATED_STATE:
                return new Creating(bid);
            case TASK_EDITING_STATE:
                return new Editing(bid);
            default:
                return null;
        }
    }
}
