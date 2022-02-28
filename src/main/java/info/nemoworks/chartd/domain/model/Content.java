package info.nemoworks.chartd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Content {

    @NonNull
    private String content;
    private String author;

}
