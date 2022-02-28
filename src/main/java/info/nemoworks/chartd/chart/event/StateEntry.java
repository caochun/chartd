package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.AbstractChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.scxml2.model.EnterableState;

@Data
@AllArgsConstructor
public class StateEntry<C extends AbstractChart> extends Event {
    private EnterableState state;
    private C chart;
}
