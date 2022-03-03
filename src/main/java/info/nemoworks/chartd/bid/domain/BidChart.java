package info.nemoworks.chartd.bid.domain;

import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.framework.AbstractChart;
import info.nemoworks.chartd.framework.Entity;
import lombok.Getter;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BidChart extends AbstractChart {

    private static final String SCXML_MODEL = "scxml/bidchart.xml";

    @Getter
    private Bid bid;

    public BidChart(Bid bid, BiConsumer<EnterableState, Entity> delegate) throws ModelException {
        super(Bid.class.getClassLoader().getResource(SCXML_MODEL), delegate,bid);
        this.bid = bid;
    }

}