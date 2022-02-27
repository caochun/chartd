package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.BaseChart;
import lombok.Getter;
import org.apache.commons.scxml2.model.EnterableState;

public class ChartStateEvent extends ChartEvent {
    @Getter
    private EnterableState state;

    public ChartStateEvent(EnterableState state, BaseChart chart) {
        super(state.getId(), chart);
        this.state = state;
    }
}
