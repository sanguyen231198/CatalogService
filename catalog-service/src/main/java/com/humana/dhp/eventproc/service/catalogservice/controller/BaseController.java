package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.Flow;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    FlowService flowService;

    @PostMapping("/import-flow")
    public String importFlow(@RequestBody Flow flow) {
        flowService.importFlowDefinition(flow);
        return "Import success";

    }
}
