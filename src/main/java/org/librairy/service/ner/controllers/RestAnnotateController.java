package org.librairy.service.ner.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.avro.AvroRemoteException;
import org.librairy.service.ner.facade.model.Annotation;
import org.librairy.service.ner.facade.model.NerService;
import org.librairy.service.ner.facade.rest.model.AnnotationRequest;
import org.librairy.service.ner.facade.rest.model.AnnotationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/annotate")
@Api(tags="/annotate", description="get detailed info about existing entities")
public class RestAnnotateController {

    private static final Logger LOG = LoggerFactory.getLogger(RestAnnotateController.class);

    @Autowired
    NerService service;

    @PostConstruct
    public void setup(){

    }

    @PreDestroy
    public void destroy(){

    }

    @ApiOperation(value = "annotations filtered by entity class", nickname = "postAnnotate", response=AnnotationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AnnotationResult.class),
    })
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public AnnotationResult analyze(@RequestBody AnnotationRequest annotationRequest)  {
        try {
            return new AnnotationResult(service.annotate(annotationRequest.getText(), annotationRequest.getFilter()).stream().map(a -> new org.librairy.service.ner.facade.rest.model.Annotation(a)).collect(Collectors.toList()));
        } catch (AvroRemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
