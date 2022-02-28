package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.AbstractChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.scxml2.model.Transition;

@Data
@AllArgsConstructor
public class TransitionTrigger<T extends AbstractChart> extends Event {
    private Transition transition;
    private T chart;
}