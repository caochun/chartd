package info.nemoworks.chartd.framework;

import com.google.common.eventbus.Subscribe;

import java.util.function.Consumer;

public class Subscriber<T extends Message> {

    private Consumer<T> consumer;

    public Subscriber(Consumer<T> consumer) {

        this.consumer = consumer;

    }

    @Subscribe
    public void on(T message) {
        this.consumer.accept(message);
    }

    ;
}
