package info.nemoworks.chartd.domain.service;

import info.nemoworks.chartd.chart.event.ChartStateEvent;
import info.nemoworks.chartd.chart.event.ChartStateHandler;
import info.nemoworks.chartd.domain.aggregate.BidAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidEditService extends ChartStateHandler {


    private BidAggregate bidAggregate;

    @Autowired
    public BidEditService(BidAggregate bidAggregate){
        this.bidAggregate = bidAggregate;
    }

    @Override
    public void handle(ChartStateEvent event) {

        if (event.getEvent().equals("created")) {

        }

    }
}
