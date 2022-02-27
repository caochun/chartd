package info.nemoworks.chartd.domain.model;

import lombok.Data;

import java.util.UUID;

public class Entity {
    private final String id = UUID.randomUUID().toString();
}
