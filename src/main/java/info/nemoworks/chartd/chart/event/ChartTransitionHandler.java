package info.nemoworks.chartd.chart.event;

public class ChartTransitionHandler implements EventHandler<ChartTransitionEvent>{

    @Override
    public void handle(ChartTransitionEvent event) {
        event.getChart().fireEvent(event.getEvent());
    }

}
