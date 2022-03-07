package info.nemoworks.chartd.framework;

import com.google.common.eventbus.Subscribe;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.FieldAccessor;

import java.util.function.Consumer;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Subscriber<T extends Message> {

    private Consumer<T> consumer;

    public Subscriber(Consumer<T> consumer) {

        this.consumer = consumer;

    }

    @Subscribe
    public void on(T message) {
        this.consumer.accept(message);
    }

//    public static void main(String[] args) {
//        Class<? extends Object> clazz = new ByteBuddy()
//                .subclass(Object.class, ConstructorStrategy.Default.NO_CONSTRUCTORS)
//                .name("SampleSon")
//                .defineField("c", Consumer.class, Visibility.PRIVATE)
//                .defineConstructor(Visibility.PUBLIC)
//                .withParameters(Consumer.class)
//                .intercept(FieldAccessor.ofField("c").setsArgumentAt(1))
//                .method(named("onMessage")).intercept(FixedValue.value("Hello World!"))
//                .make()
//                .load(ClassLoader.getSystemClassLoader())
//                .getLoaded();
//    }
}
