package info.nemoworks.chartd.domain.repository;

import info.nemoworks.chartd.domain.model.BidChart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BidChartRepository {

    private Map<String, BidChart> charts = new HashMap<>();

    public void save(BidChart bidChart) {
        charts.put(bidChart.getBid().getId(), bidChart);
    }

    public BidChart get(String bidId) {
        return charts.get(bidId);
    }
}
