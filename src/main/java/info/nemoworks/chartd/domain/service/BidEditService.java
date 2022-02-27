package info.nemoworks.chartd.domain.service;

import info.nemoworks.chartd.chart.event.ChartStateEvent;
import info.nemoworks.chartd.chart.event.ChartStateHandler;
import info.nemoworks.chartd.domain.aggregate.BidAggregate;
import info.nemoworks.chartd.domain.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BidEditService extends ChartStateHandler {

    private Map<String, Bid> pendings = new HashMap<>();


    private BidAggregate bidAggregate;

    @Autowired
    public BidEditService(BidAggregate bidAggregate) {
        this.bidAggregate = bidAggregate;
    }


    @Override
    public void handle(ChartStateEvent event) {

        if (event.getEvent().equals("created")) {

        }

    }
}
