package info.nemoworks.chartd.framework;

import lombok.Getter;
import lombok.NonNull;

public class Query<T extends Entity> extends Message {

    @NonNull
    @Getter
    private String context;


    public Query(@NonNull T subject, @NonNull String context) {
        super(subject);
        this.context = context;
    }
}
