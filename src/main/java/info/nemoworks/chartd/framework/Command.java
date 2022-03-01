package info.nemoworks.chartd.framework;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Command<T extends Entity> extends Message {


}
