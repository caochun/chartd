package info.nemoworks.chartd.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Actor {

    private Stub stub;

    @Autowired
    public void setStub(Stub stub) {
        this.stub = stub;
    }

    public Stub getStub(){
        return this.stub;
    }
}
