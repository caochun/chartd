package info.nemoworks.chartd.framework;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Task<T extends Entity> extends Message {

    @NonNull
    private T target;

    @NonNull
    private String task;
}
