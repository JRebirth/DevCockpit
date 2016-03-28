package org.jrebirth.demo.devcockpit.ui;

import org.jrebirth.af.api.annotation.LinkComponent;
import org.jrebirth.af.api.ui.ModuleModel;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.component.ui.stack.StackModel;
import org.jrebirth.af.core.key.Key;
import org.jrebirth.af.core.ui.DefaultModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>SampleModel</strong>.
 * 
 * @author
 */
public final class MainModel extends DefaultModel<MainModel, MainView> {

    private static final String ROOT_STACK_ID = "RootStack";

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MainModel.class);

    @LinkComponent(ROOT_STACK_ID)
    private StackModel stackModel;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initModel() {
        LOGGER.debug("Init Sample Model");

        // getView().getRootNode().setCenter(getModel(JenkinsModel.class).getRootNode());

        getView().getRootNode().setCenter(stackModel.getRootNode());

        for (final ModuleModel mm : getModels(ModuleModel.class)) {
            stackModel.doShowPageModel(Key.create(mm.getClass()), ROOT_STACK_ID, null);
        }
        /*
         * stackModel.doShowPageModel(Key.create(JenkinsPluginModel.class), ROOT_STACK_ID, null); stackModel.doShowPageModel(Key.create(JRebirthPluginModel.class), ROOT_STACK_ID, null);
         */
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processWave(final Wave wave) {
        // Process a wave action, you must listen the wave type before
    }

}
