package info.nemoworks.chartd.domain.model;

import lombok.*;

import java.time.Instant;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BidAddon {

    private final Instant timestamp = Instant.now();

    @NonNull
    private String bidId;

    @NonNull
    private String message;

    private String author;

}
