package info.nemoworks.chartd.chart;

import info.nemoworks.chartd.entity.Bid;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.scxml2.model.ModelException;
import org.springframework.stereotype.Component;

@Component
public class BidChart extends BaseChart {

    private static final String SCXML_MODEL = "scxml/bid.xml";

    @Getter
    @Setter
    private Bid bid;

    public BidChart(Bid bid) throws ModelException {
        super(Bid.class.getClassLoader().getResource(SCXML_MODEL));
        this.bid = bid;
    }

    public BidChart() throws ModelException {
        this(new Bid());
    }


}
