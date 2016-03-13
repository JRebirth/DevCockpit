package org.jrebirth.demo.devcockpit.ui;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.DefaultController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public final class MainController extends DefaultController<MainModel, MainView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public MainController(final MainView view) throws CoreException {
        super(view);
    }

}
