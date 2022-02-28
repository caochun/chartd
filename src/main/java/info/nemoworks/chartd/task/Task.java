package info.nemoworks.chartd.task;

import info.nemoworks.chartd.domain.model.Entity;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Task<T extends Entity> {

    private final UUID id = UUID.randomUUID();
    private final Instant timestamp = Instant.now();

    @NonNull
    private T target;

    @NonNull
    private String task;

}
