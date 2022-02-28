package info.nemoworks.chartd.domain.model;

import info.nemoworks.chartd.chart.AbstractChart;
import lombok.Getter;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;

import java.util.function.Consumer;

public class BidChart extends AbstractChart {

    private static final String SCXML_MODEL = "scxml/bidchart.xml";

    @Getter
    private Bid bid;

    public BidChart(Bid bid, Consumer<EnterableState> delegate) throws ModelException {
        super(Bid.class.getClassLoader().getResource(SCXML_MODEL), delegate);
        this.bid = bid;
    }


}
