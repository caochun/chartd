package info.nemoworks.chartd.domain.service;

import info.nemoworks.chartd.chart.event.StateEvent;
import info.nemoworks.chartd.chart.event.EventDispatcher;
import info.nemoworks.chartd.domain.model.Bid;
import info.nemoworks.chartd.domain.model.BidChart;
import info.nemoworks.chartd.domain.repository.BidChartRepository;
import org.apache.commons.scxml2.model.ModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    public BidChart createBidChart(Bid bid) {
        BidChart bidChart;

        try {
            bidChart = new BidChart(bid, (s) -> {
                this.eventDispatcher.dispatch(new StateEvent(s, bid));
            });
        } catch (ModelException e) {
            return null;
        }

        this.bidChartRepository.save(bidChart);
        return bidChart;
    }
}
