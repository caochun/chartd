package info.nemoworks.chartd.framework;

import lombok.Getter;
import lombok.NonNull;

public abstract class Command<T extends Entity> extends Message {

    @Getter
    private T target;

    public Command(@NonNull T target) {
        this.target = target;
    }
}
