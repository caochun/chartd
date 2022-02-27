package info.nemoworks.chartd.chart.event;

import lombok.Getter;
import org.apache.commons.scxml2.model.Transition;

public class ChartTransitionEvent extends ChartEvent {

    @Getter
    private Transition transition;

    public ChartTransitionEvent(Transition transition) {
        super(transition.getEvent());
        this.transition = transition;
    }
}
