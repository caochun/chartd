package info.nemoworks.chartd.domain.command;

import info.nemoworks.chartd.domain.model.Entity;
import lombok.*;

@AllArgsConstructor
public abstract class Command<T extends Entity> {

    @Getter
    @NonNull
    private T target;
}
