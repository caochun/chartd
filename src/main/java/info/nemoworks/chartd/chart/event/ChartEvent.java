package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.BaseChart;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ChartEvent {

    private final UUID id = UUID.randomUUID();
    private final Instant timestamp = Instant.now();

    @NonNull
    private String event;
    @NonNull
    private BaseChart chart;


}
