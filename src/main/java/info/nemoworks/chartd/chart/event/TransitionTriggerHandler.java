package info.nemoworks.chartd.chart.event;

import info.nemoworks.chartd.chart.AbstractChart;

public abstract class TransitionTriggerHandler<T extends AbstractChart> implements EventHandler<TransitionTrigger<T>>{

    @Override
    public abstract void handle(TransitionTrigger<T> transitionTrigger);

}
