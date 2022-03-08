package info.nemoworks.chartd.framework;

import lombok.Getter;
import lombok.NonNull;

public class Query<T extends Entity> {

    @Getter
    private T source;

    public Query(@NonNull T source) {
        this.source = source;
    }
}