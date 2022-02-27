package info.nemoworks.chartd.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Bid extends Entity {

    private String creator;

    private String title;

    private BidContent content;

    private List<BidAddon> addons = new ArrayList<>();

    private boolean approved;

    private boolean closed;

}