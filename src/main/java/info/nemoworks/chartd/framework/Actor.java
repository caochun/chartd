package info.nemoworks.chartd.framework;

public interface Actor<T extends Message> {
    public void onMessage(T message);
}
