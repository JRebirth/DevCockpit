package org.jrebirth.demo.devcockpit.service;

import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveItem;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.Builders;
import org.jrebirth.af.core.wave.WaveItemBase;
import org.jrebirth.af.processor.annotation.RegistrationPoint;
import org.jrebirth.demo.devcockpit.model.Hudson;

/**
 * The class <strong>SampleService</strong>.
 * 
 * @author
 */
@RegistrationPoint(exclusive = true)
public interface LoadService extends Service {

    WaveItem<Hudson> HUDSON = new WaveItemBase<Hudson>() {
    };

    WaveType DO_LOAD_MAIN = Builders.waveType("LOAD_MAIN").returnAction("MAIN_LOADED");

    /** Wave type to return when something was done. */
    WaveType RE_MAIN_LOADED = Builders.waveType("MAIN_LOADED").returnItem(HUDSON);

    /**
     * Do something.
     *
     * @param wave the source wave
     */
    Hudson loadMain(final Wave wave);

}
