package info.nemoworks.chartd.framework;

import lombok.Getter;

import java.util.UUID;

public class Entity {

    @Getter
    private final String id = UUID.randomUUID().toString();
}
