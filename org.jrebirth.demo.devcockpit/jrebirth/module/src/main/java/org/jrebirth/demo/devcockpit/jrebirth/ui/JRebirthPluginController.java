package org.jrebirth.demo.devcockpit.jrebirth.ui;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.AbstractController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public final class JRebirthPluginController extends AbstractController<JRebirthPluginModel, JRebirthPluginView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JRebirthPluginController.class);

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public JRebirthPluginController(final JRebirthPluginView view) throws CoreException {
        super(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventAdapters() throws CoreException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventHandlers() throws CoreException {
        // Listen events

    }

}
