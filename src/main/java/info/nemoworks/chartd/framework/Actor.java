package info.nemoworks.chartd.framework;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
