package info.nemoworks.chartd.domain.service;


import info.nemoworks.chartd.chart.event.StateEntryHandler;
import info.nemoworks.chartd.chart.event.StateEvent;
import info.nemoworks.chartd.chart.event.ChartStateHandler;
import info.nemoworks.chartd.domain.aggregate.BidAggregate;
import info.nemoworks.chartd.domain.command.CreateCommand;
import info.nemoworks.chartd.domain.model.Bid;
import info.nemoworks.chartd.domain.model.BidChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService  {

    private StateEntryHandler<BidChart> handler;

    private BidAggregate bidAggregate;

    @Autowired
    public void setBidAggregate(BidAggregate bidAggregate) {
        this.bidAggregate = bidAggregate;
    }

    public Bid createBid(String title, String author){
        return bidAggregate.handleCreateCommand(new CreateCommand(title, author));
    }

    public void enqueueEditingList(Bid bid){

    }

    @Override
    public void handle(StateEvent event) {

        switch (event.getEvent()){
            case "created":
                this.enqueueEditingList(event.getEntity());

        }




    }

}
