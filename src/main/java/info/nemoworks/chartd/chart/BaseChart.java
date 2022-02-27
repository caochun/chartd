package info.nemoworks.chartd.chart;

import info.nemoworks.chartd.chart.event.ChartStateEvent;
import info.nemoworks.chartd.chart.event.ChartTransitionEvent;
import info.nemoworks.chartd.chart.event.EventDispatcher;
import info.nemoworks.chartd.chart.event.EventHandler;
import org.apache.commons.scxml2.SCXMLListener;
import org.apache.commons.scxml2.env.AbstractStateMachine;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.Transition;
import org.apache.commons.scxml2.model.TransitionTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public abstract class BaseChart extends AbstractStateMachine implements EventHandler<ChartTransitionEvent> {

    private Logger logger = LoggerFactory.getLogger(BaseChart.class);


    private EventDispatcher eventDispatcher;


    public BaseChart(URL scxmlDocument) throws ModelException {
        super(scxmlDocument);
    }

    @PostConstruct
    public void initBus() {

        this.getEngine().addListener(this.getEngine().getStateMachine(), new SCXMLListener() {
            @Override
            public void onEntry(EnterableState enterableState) {
                BaseChart.this.eventDispatcher.dispatch(new ChartStateEvent(enterableState));
            }

            @Override
            public void onExit(EnterableState enterableState) {

            }

            @Override
            public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget1, Transition transition, String s) {
                BaseChart.this.eventDispatcher.dispatch(new ChartTransitionEvent(transition));

            }
        });
    }

    @Override
    public void handle(ChartTransitionEvent event) {
        logger.info("Triggering transition: " + event.getEvent());
        this.fireEvent(event.getEvent());
    }

    /**
     * Keep the statemachine silent if a method is missing for a state
     *
     * @param methodName
     * @return
     */
    @Override
    public boolean invoke(String methodName) {
        Class clas = this.getClass();

        try {
            Method method = clas.getDeclaredMethod(methodName, new Class[0]);
            method.invoke(this, new Object[0]);
            return true;
        } catch (SecurityException var4) {
            this.logError(var4);
            return false;
        } catch (NoSuchMethodException var5) {
//            this.logError(var5);
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

}
