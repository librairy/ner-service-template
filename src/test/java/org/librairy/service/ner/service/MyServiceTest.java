package org.librairy.service.ner.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.librairy.service.ner.facade.model.Annotation;
import org.librairy.service.ner.facade.model.Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyService.class)
@WebAppConfiguration
public class MyServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(MyServiceTest.class);

    @Autowired
    MyService service;

    @Test
    public void annotation() throws IOException {

        String text = "Sample text";

        List<Class> filter = Collections.emptyList();

        List<Annotation> annotations = service.annotate(text, filter);

        LOG.info("Annotations: " + annotations);

//        Assert.assertEquals(2, annotations.size());
    }
}