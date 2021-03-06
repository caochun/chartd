package info.nemoworks.chartd.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.scxml2.*;
import org.apache.commons.scxml2.env.SimpleDispatcher;
import org.apache.commons.scxml2.env.SimpleErrorReporter;
import org.apache.commons.scxml2.env.jexl.JexlContext;
import org.apache.commons.scxml2.env.jexl.JexlEvaluator;
import org.apache.commons.scxml2.io.SCXMLReader;
import org.apache.commons.scxml2.model.*;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.function.BiConsumer;

public abstract class AbstractChart<T extends Entity> {
    private SCXML stateMachine;
    private SCXMLExecutor engine;
    private Log log;
    private static final Class<?>[] SIGNATURE = new Class[0];
    private static final Object[] PARAMETERS = new Object[0];

    private T entity;

    public T getEntity(){
        return entity;
    }


    public AbstractChart(URL scxmlDocument, BiConsumer<EnterableState, T> stateConsumer, T entity) throws ModelException {
        this((URL) scxmlDocument, new JexlContext(), new JexlEvaluator(), stateConsumer, entity);
    }

    public AbstractChart(URL scxmlDocument, Context rootCtx, Evaluator evaluator, BiConsumer<EnterableState,T> stateConsumer, T entity) throws ModelException {
        this.log = LogFactory.getLog(this.getClass());

        try {
            this.stateMachine = SCXMLReader.read(scxmlDocument);
        } catch (IOException var5) {
            this.logError(var5);
        } catch (XMLStreamException var6) {
            this.logError(var6);
        } catch (ModelException var7) {
            this.logError(var7);
        }

        this.initialize(this.stateMachine, rootCtx, evaluator, stateConsumer, entity);
    }


    private void initialize(SCXML stateMachine, Context rootCtx, Evaluator evaluator, BiConsumer<EnterableState, T> stateConsumer, T entity) throws ModelException {
        this.engine = new SCXMLExecutor(evaluator, new SimpleDispatcher(), new SimpleErrorReporter());
        this.engine.setStateMachine(stateMachine);
        this.engine.setRootContext(rootCtx);
        this.engine.addListener(stateMachine, new AbstractChart.EntryListener(stateConsumer));
        this.entity = entity;

        try {
            this.engine.go();
        } catch (ModelException var5) {
            this.logError(var5);
        }

    }

    public boolean fireEvent(String event) {
        TriggerEvent[] evts = new TriggerEvent[]{new TriggerEvent(event, 3)};

        try {
            this.engine.triggerEvents(evts);
        } catch (ModelException var4) {
            this.logError(var4);
        }

        return this.engine.getCurrentStatus().isFinal();
    }

    public SCXMLExecutor getEngine() {
        return this.engine;
    }

    public Log getLog() {
        return this.log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public boolean invoke(String methodName) {
        Class clas = this.getClass();

        try {
            Method method = clas.getDeclaredMethod(methodName, SIGNATURE);
            method.invoke(this, PARAMETERS);
            return true;
        } catch (SecurityException var4) {
            this.logError(var4);
            return false;
        } catch (NoSuchMethodException var5) {
            this.logError(var5);
            return false;
        } catch (IllegalArgumentException var6) {
            this.logError(var6);
            return false;
        } catch (IllegalAccessException var7) {
            this.logError(var7);
            return false;
        } catch (InvocationTargetException var8) {
            this.logError(var8);
            return false;
        }
    }

    public boolean resetMachine() {
        try {
            this.engine.reset();
            return true;
        } catch (ModelException var2) {
            this.logError(var2);
            return false;
        }
    }

    protected void logError(Exception exception) {
        if (this.log.isErrorEnabled()) {
            this.log.error(exception.getMessage(), exception);
        }

    }

    protected class EntryListener implements SCXMLListener {
        BiConsumer<EnterableState, Entity> stateConsumer;

        protected EntryListener(BiConsumer<EnterableState, Entity> stateConsumer) {
            this.stateConsumer = stateConsumer;
        }

        public void onEntry(EnterableState entered) {
            stateConsumer.accept(entered, entity);
        }

        public void onTransition(TransitionTarget from, TransitionTarget to, Transition transition, String event) {
        }

        public void onExit(EnterableState exited) {
        }
    }
}
