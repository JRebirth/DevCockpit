package org.jrebirth.demo.devcockpit.jrebirth.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.AbstractView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleView</strong>.
 * 
 * @author
 */
public final class JRebirthPluginView extends AbstractView<JRebirthPluginModel, BorderPane, JRebirthPluginController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JRebirthPluginView.class);

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public JRebirthPluginView(final JRebirthPluginModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        final Label descLabel = new Label();
        descLabel.setText("jrebrth plugin");
        getRootNode().setCenter(descLabel);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        LOGGER.debug("Start the Sample View");
        // Custom code to process when the view is displayed the first time
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        LOGGER.debug("Reload the Sample View");
        // Custom code to process when the view is displayed the 1+n time
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        LOGGER.debug("Hide the Sample View");
        // Custom code to process when the view is hidden
    }

    public void fillView() {

    }

}
