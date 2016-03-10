package org.jrebirth.demo.devcockpit.ui;

import javafx.scene.input.MouseEvent;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.AbstractController;
import org.jrebirth.af.core.ui.adapter.DefaultMouseAdapter;
import org.jrebirth.demo.devcockpit.service.LoadService;
import org.jrebirth.demo.devcockpit.service.LoadServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleController</strong>.
 * 
 * @author
 */
public final class MainController extends AbstractController<MainModel, MainView> {

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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventAdapters() throws CoreException {

        // Manage Ui Command Button
        // linkCommand(getView().getUiCommand(), MouseEvent.MOUSE_CLICKED, SampleUICommand.class);

        // Use the inner class
        addAdapter(new SampleMouseAdapter());

        linkService(getView().getUiCommand(), MouseEvent.MOUSE_CLICKED, LoadServiceImpl.class, LoadService.DO_LOAD_MAIN);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initEventHandlers() throws CoreException {
        // Listen events

        // Manage Pooled Command Button
        getView().getPooledCommand().setOnMouseClicked(getHandler(MouseEvent.MOUSE_CLICKED));
    }

    /**
     * Manage Mouse click of widget that have annotation.
     * 
     * @param event the mouse event
     */
    void onMouseClicked(final MouseEvent event) {

        LOGGER.debug("MouseClicked => Call Sample Command");

        // Manage Default Command Button
        // getModel().getCommand(SampleCommand.class).run();

    }

    /**
     * The class <strong>SampleMouseAdapter</strong>.
     */
    private class SampleMouseAdapter extends DefaultMouseAdapter<MainController> {

        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);

            LOGGER.debug("MouseClicked => Call Sample Pool Command");

            // getModel().sendWave(Builders.callCommand(SamplePoolCommand.class));

        }

    }

}
