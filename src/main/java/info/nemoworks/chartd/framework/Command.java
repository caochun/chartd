package info.nemoworks.chartd.framework;

import info.nemoworks.chartd.framework.Entity;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public abstract class Command<T extends Entity> {

    private final UUID id = UUID.randomUUID();
    private final Instant timestamp = Instant.now();

    @NonNull
    private T target;
}
