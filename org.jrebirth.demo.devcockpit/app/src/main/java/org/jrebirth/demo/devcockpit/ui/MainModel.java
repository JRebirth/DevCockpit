package org.jrebirth.demo.devcockpit.ui;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.ui.DefaultModel;
import org.jrebirth.demo.devcockpit.model.HudsonModelHudson;
import org.jrebirth.demo.devcockpit.service.LoadService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
public final class MainModel extends DefaultModel<MainModel, MainView> {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainModel.class);

    private HudsonModelHudson hudson;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {
        LOGGER.debug("Init Sample Model");
        // Put the code to initialize your model here

        listen(LoadService.RE_MAIN_LOADED);

        // getService(LoadServiceImpl.class);
        returnData(LoadService.class, LoadService.DO_LOAD_MAIN);

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

    public void mainLoader(HudsonModelHudson hudson, Wave wave) {
        this.hudson = hudson;
        getView().fillView();
    }

    /**
     * @return Returns the hudson.
     */
    HudsonModelHudson getHudson() {
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
