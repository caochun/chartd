package info.nemoworks.chartd.domain.service;

import info.nemoworks.chartd.chart.event.ChartStateEvent;
import info.nemoworks.chartd.chart.event.ChartStateHandler;
import info.nemoworks.chartd.domain.model.Bid;
import org.springframework.stereotype.Service;

@Service
public class BidEditService extends ChartStateHandler {

    public Bid create(){
        return new Bid();
    }


    @Override
    public void handle(ChartStateEvent event) {

    }
}
