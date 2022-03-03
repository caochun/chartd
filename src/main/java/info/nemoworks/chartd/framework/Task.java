package info.nemoworks.chartd.framework;

import lombok.Getter;
import lombok.NonNull;

public class Task<T extends Entity> extends Message {

    @NonNull
    private String task;

    @Getter
    private T subject;

    public Task(@NonNull T subject, @NonNull String task) {
        super();
        this.subject = subject;
        this.task = task;
    }
}
