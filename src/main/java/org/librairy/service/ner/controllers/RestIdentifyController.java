package org.librairy.service.ner.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.avro.AvroRemoteException;
import org.librairy.service.ner.facade.model.NerService;
import org.librairy.service.ner.facade.rest.model.Entity;
import org.librairy.service.ner.facade.rest.model.IdentifyRequest;
import org.librairy.service.ner.facade.rest.model.IdentifyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/identify")
@Api(tags = "/identify", description = "discover entities in text")
public class RestIdentifyController {

    private static final Logger LOG = LoggerFactory.getLogger(RestIdentifyController.class);

    @Autowired
    NerService service;

    @PostConstruct
    public void setup(){

    }

    @PreDestroy
    public void destroy(){

    }

    @ApiOperation(value = "entities filtered by class", nickname = "postIdentify", response=IdentifyRequest.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = IdentifyResult.class),
    })
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public IdentifyResult analyze(@RequestBody IdentifyRequest identifyRequest)  {
        try {
            return new IdentifyResult(service.identify(identifyRequest.getText(), identifyRequest.getFilter()).stream().map(e -> new Entity(e)).collect(Collectors.toList()));
        } catch (AvroRemoteException e) {
            throw new RuntimeException(e);
        }
    }

}
