package org.jrebirth.demo.devcockpit.service;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jrebirth.af.api.wave.Wave;
import org.jrebirth.af.core.service.DefaultService;
import org.jrebirth.af.processor.annotation.Register;
import org.jrebirth.af.processor.annotation.WarmUp;
import org.jrebirth.demo.devcockpit.model.Hudson;
import org.jrebirth.demo.devcockpit.model.ObjectFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <strong>LoadServiceImpl</strong>.
 * 
 * @author
 */
@Register(value = LoadService.class)
@WarmUp
public final class LoadServiceImpl extends DefaultService implements LoadService {

    /** The class logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadServiceImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void initService() {
        // Define the service method
        listen(DO_LOAD_MAIN);
    }

    /**
     * Do something.
     *
     * @param wave the source wave
     */
    @Override
    public Hudson loadMain(final Wave wave) {

        LOGGER.trace("Do Something.");

        Hudson hudson = null;

        final CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            // Define a postRequest request
            final HttpPost postRequest = new HttpPost("http://ci.jrebirth.org/api/xml");

            // Set the API media type in http content-type header
            postRequest.addHeader("content-type", "application/xml");

            // postRequest.

            // Set the request post body
            // final StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
            // postRequest.setEntity(userEntity);

            // Send the request; It will immediately return the response in HttpResponse object if any
            final HttpResponse response = httpClient.execute(postRequest);

            // verify the valid error code first
            final int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            // Now pull back the response object
            final HttpEntity httpEntity = response.getEntity();
            final String apiOutput = EntityUtils.toString(httpEntity);

            // Lets see what we got from API
            System.out.println(apiOutput); // <user id="10"><firstName>demo</firstName><lastName>user</lastName></user>

            // In realtime programming, you will need to convert this http response to some java object to re-use it.
            // Lets see how to jaxb unmarshal the api response content
            final JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            final JAXBElement ele = (JAXBElement) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));

            hudson = (Hudson) ele.getValue();

        } catch (final IOException | JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Important: Close the connect
            // httpClient.close();
        }
        return hudson;
    }

}
