package Handler;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class DefaultExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public DefaultExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		Iterator<ExceptionQueuedEvent> eventIterator = getUnhandledExceptionQueuedEvents()
				.iterator();

		ViewExpiredException viewExpiredException = getViewExpiredException(getUnhandledExceptionQueuedEvents());
		if (viewExpiredException != null) {
			System.out.println("View expired.");
			redirectToTheErrorPage(facesContext);
		} else if (eventIterator.hasNext()) {
			ExceptionQueuedEvent queuedEvent = (ExceptionQueuedEvent) eventIterator
					.next();
			ExceptionQueuedEventContext exception = (ExceptionQueuedEventContext) queuedEvent
					.getSource();			
			System.out.println(exception.getException().getMessage());
		}

	}

	private void redirectToTheErrorPage(FacesContext facesContext) {

		String contextPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestContextPath();

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(contextPath + "/login.jsf?faces-redirect=true");
		} catch (IOException exception) {

			System.out.println(exception.getMessage());
		}

	}

	private ViewExpiredException getViewExpiredException(
			Iterable<ExceptionQueuedEvent> unhandledExceptionQueuedEvents) {
		for (ExceptionQueuedEvent event : unhandledExceptionQueuedEvents) {
			ExceptionQueuedEventContext queuedEventContext = event.getContext();
			if (queuedEventContext.getException() instanceof ViewExpiredException) {
				return (ViewExpiredException) queuedEventContext.getException();
			}
		}
		return null;
	}

}
