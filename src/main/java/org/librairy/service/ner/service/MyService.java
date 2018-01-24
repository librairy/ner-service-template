package org.librairy.service.ner.service;

import org.apache.avro.AvroRemoteException;
import org.librairy.service.ner.facade.model.Annotation;
import org.librairy.service.ner.facade.model.Class;
import org.librairy.service.ner.facade.model.Entity;
import org.librairy.service.ner.facade.model.NerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class MyService implements NerService {

    private static final Logger LOG = LoggerFactory.getLogger(MyService.class);

    @Value("#{environment['RESOURCE_FOLDER']?:'${resource.folder}'}")
    String resourceFolder;

    String model              ;

    @PostConstruct
    public void setup() throws IOException {

        //// Load resources
        //model              = Paths.get(resourceFolder,"resource.bin").toFile().getAbsolutePath();

        LOG.info("Service initialized");
    }

    @Override
    public List<Entity> identify(String text, List<Class> filter) throws AvroRemoteException {

        LOG.debug("Processing text: "+ text + " by criteria: " + filter);

        // TODO
        return Collections.emptyList();
    }

    @Override
    public List<Annotation> annotate(String text, List<Class> filter) throws AvroRemoteException {
        LOG.debug("Annotating text: "+ text + " by criteria: " + filter );
        // TODO
        return Collections.emptyList();
    }

}
