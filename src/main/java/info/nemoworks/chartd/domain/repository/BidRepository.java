package info.nemoworks.chartd.domain.repository;

import info.nemoworks.chartd.domain.model.Bid;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class BidRepository {
    private Map<String, Bid> bids = new HashMap<String, Bid>();

    public void saveBid(Bid bid) {
        bids.put(bid.getId(), bid);
    }

    public Bid getBid(String bidId) {
        return bids.get(bidId);
    }
}
