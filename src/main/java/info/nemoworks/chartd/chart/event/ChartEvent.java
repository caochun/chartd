package info.nemoworks.chartd.chart.event;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

public class ChartEvent {
    @Getter
    private UUID id;
    @Getter
    private Instant timestamp;
    @Getter
    private String event;

    public ChartEvent(String event) {
        this.id = UUID.randomUUID();
        this.timestamp = Instant.now();
        this.event = event;
    }
}
