package info.nemoworks.chartd.chart.event;

import lombok.Getter;
import org.apache.commons.scxml2.model.EnterableState;

public class ChartStateEvent extends ChartEvent {
    @Getter
    private EnterableState state;

    public ChartStateEvent(EnterableState state) {
        super(state.getId());
        this.state = state;
    }
}
