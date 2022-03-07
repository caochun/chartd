package info.nemoworks.chartd.framework;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Message {

    private final UUID id = UUID.randomUUID();
    private final Instant timestamp = Instant.now();

}
