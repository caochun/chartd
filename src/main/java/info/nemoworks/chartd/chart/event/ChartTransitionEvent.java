package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.BaseChart;
import lombok.Getter;
import org.apache.commons.scxml2.model.Transition;

public class ChartTransitionEvent extends ChartEvent {

    @Getter
    private Transition transition;

    public ChartTransitionEvent(Transition transition, BaseChart chart) {
        super(transition.getEvent(), chart);
        this.transition = transition;
    }
}
