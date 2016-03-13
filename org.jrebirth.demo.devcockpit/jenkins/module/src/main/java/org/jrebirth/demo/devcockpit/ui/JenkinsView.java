package org.jrebirth.demo.devcockpit.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.core.ui.AbstractView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleView</strong>.
 * 
 * @author
 */
public final class JenkinsView extends AbstractView<JenkinsModel, BorderPane, JenkinsController> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsView.class);

    private WebView descLabel;

    private WebEngine webEngine;

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public JenkinsView(final JenkinsModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        descLabel = new WebView();
        webEngine = descLabel.getEngine();

        webEngine.loadContent("trying to connect to Jenkins instance : ci.jrebirth.org");
        getRootNode().setTop(descLabel);

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
        final StringBuilder sb = new StringBuilder();

        sb.append(getModel().getHudson().getDescription());

        for (final Object job : getModel().getHudson().getJob()) {
            // sb.append("\\r\\n").append(((HudsonModelJob) job).getDisplayName());
        }

        webEngine.loadContent(sb.toString());

    }

}
