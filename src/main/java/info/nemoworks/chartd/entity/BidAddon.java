package info.nemoworks.chartd.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

public class BidAddon {
    private Instant timestamp;

    @Getter
    @Setter
    private String message;

    public BidAddon(String message) {
        this.timestamp = Instant.now();
        this.message = message;
    }
}
