package org.jrebirth.demo.devcockpit.ui;

import org.jrebirth.af.api.ui.annotation.CreateViewIntoJAT;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.DefaultModel;
import org.jrebirth.demo.devcockpit.model.Hudson;
import org.jrebirth.demo.devcockpit.service.LoadService;
import org.jrebirth.demo.devcockpit.service.LoadServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
@CreateViewIntoJAT
public final class JenkinsModel extends DefaultModel<JenkinsModel, JenkinsView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsModel.class);

    private Hudson hudson;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {
        LOGGER.debug("Init Sample Model");
        // Put the code to initialize your model here

        listen(LoadService.RE_MAIN_LOADED);

        getService(LoadServiceImpl.class);
        // getService(LoadServiceImpl.class);
        returnData(LoadServiceImpl.class, LoadService.DO_LOAD_MAIN);

        // hudson = getService(LoadServiceImpl.class).loadMain(null);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initInnerComponents() {
        // Put the code to initialize inner models here (if any)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void bind() {
        // Put the code to manage model object binding (if any)
    }

    public void doMainLoaded(Hudson hudson, Wave wave) {
        this.hudson = hudson;
        getView().fillView();
    }

    /**
     * @return Returns the hudson.
     */
    Hudson getHudson() {
        return hudson;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processWave(final Wave wave) {
        // Process a wave action, you must listen the wave type before
    }

}
