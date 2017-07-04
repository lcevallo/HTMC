package Handler;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean etapa_desarrollo = false;

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		if (etapa_desarrollo)
			System.out.println("START PHASE " + event.getPhaseId());
	}

	public void afterPhase(PhaseEvent event) {
		if (etapa_desarrollo)
			System.out.println("END PHASE " + event.getPhaseId());
	}

}