package info.nemoworks.chartd.domain.service;

import info.nemoworks.chartd.chart.event.ChartStateEvent;
import info.nemoworks.chartd.chart.event.ChartTransitionEvent;
import info.nemoworks.chartd.chart.event.EventDispatcher;
import info.nemoworks.chartd.domain.model.BidChart;
import info.nemoworks.chartd.domain.repository.BidChartRepository;
import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;
import org.springframework.beans.factory.annotation.Autowired;

public class BidChartService {

    private BidChartRepository bidChartRepository;

    @Autowired
    public void setBidChartRepository(BidChartRepository bidChartRepository) {
        this.bidChartRepository = bidChartRepository;
    }

    private EventDispatcher eventDispatcher;

    @Autowired
    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public BidChart createBidChart() {
        try {
            BidChart bidChart = new BidChart();
            bidChart.getEngine().addListener(bidChart.getEngine().getStateMachine(), new SCXMLListener() {
                @Override
                public void onEntry(EnterableState enterableState) {
                    eventDispatcher.dispatch(new ChartStateEvent(enterableState, bidChart));
                }

                @Override
                public void onExit(EnterableState enterableState) {

                }

                @Override
                public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget1, Transition transition, String s) {
                    eventDispatcher.dispatch(new ChartTransitionEvent(transition, bidChart));
                }
            });

            bidChartRepository.save(bidChart);
            return bidChart;
        } catch (ModelException e) {
            return null;
        }
    }


}
