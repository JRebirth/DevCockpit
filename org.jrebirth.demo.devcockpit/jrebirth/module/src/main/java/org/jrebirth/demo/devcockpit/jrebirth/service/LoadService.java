package org.jrebirth.demo.devcockpit.jrebirth.service;

import org.jrebirth.af.api.module.RegistrationPoint;
import org.jrebirth.af.api.service.Service;
import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.api.wave.contract.WaveItem;
import org.jrebirth.af.api.wave.contract.WaveType;
import org.jrebirth.af.core.wave.Builders;
import org.jrebirth.af.core.wave.WaveItemBase;
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

    /** Wave type to return when something was done. */
    WaveType RE_MAIN_LOADED = Builders.waveType("MAIN_LOADED").items(HUDSON);

    WaveType DO_LOAD_MAIN = Builders.waveType("LOAD_MAIN")
                                    .returnWaveType(RE_MAIN_LOADED);

    /**
     * Do something.
     *
     * @param wave the source wave
     */
    Hudson doLoadMain(final Wave wave);

}
