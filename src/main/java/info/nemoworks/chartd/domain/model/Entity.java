package info.nemoworks.chartd.domain.model;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

public class Entity {

    @Getter
    private final String id = UUID.randomUUID().toString();
}
