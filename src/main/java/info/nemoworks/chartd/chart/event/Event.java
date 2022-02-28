package info.nemoworks.chartd.chart.event;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class Event {

    private final UUID id = UUID.randomUUID();
    private final Instant timestamp = Instant.now();

}
