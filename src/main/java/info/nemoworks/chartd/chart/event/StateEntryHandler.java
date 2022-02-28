package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.AbstractChart;

public abstract class StateEntryHandler<T extends AbstractChart> implements EventHandler<StateEntry<T>> {

    @Override
    public abstract void handle(StateEntry<T> stateEntry);

}
