package org.jrebirth.demo.devcockpit;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.jrebirth.af.api.ui.Model;
import org.jrebirth.af.core.application.DefaultApplication;
import org.jrebirth.demo.devcockpit.ui.JenkinsModel;

/**
 * The class <strong>SampleApplication</strong>.
 * 
 * @author
 */
public final class JenkinsApplication extends DefaultApplication<StackPane> {

    /**
     * Application launcher.
     * 
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        preloadAndLaunch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Model> getFirstModelClass() {
        return JenkinsModel.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeStage(final Stage stage) {
        stage.setFullScreen(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customizeScene(final Scene scene) {
        // addCSS(scene, SampleStyles.MAIN);
    }

    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected List<? extends ResourceItem<?, ?, ?>> getResourceToPreload() {
    // return Arrays.asList(new FontItem[] {
    // SampleFonts.SPLASH,
    // });
    // }

}
