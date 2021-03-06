package org.jrebirth.demo.devcockpit.resources;

import static org.jrebirth.af.core.resource.Resources.create;

import org.jrebirth.af.api.resource.font.FontItem;
import org.jrebirth.af.core.resource.font.RealFont;

/**
 * The class <strong>SampleFonts</strong>.
 * 
 * @author
 */
public interface DCFonts {

    /** The splash font. */
    FontItem SPLASH = create(new RealFont(JenkinsFontNames.DINk, 24));

}
