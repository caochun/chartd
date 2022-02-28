package info.nemoworks.chartd.task;

import info.nemoworks.chartd.domain.command.Command;
import info.nemoworks.chartd.domain.model.Entity;

public interface TaskInputBoundary<T extends Entity> {

    public Command execute(Task<T> task);
}
