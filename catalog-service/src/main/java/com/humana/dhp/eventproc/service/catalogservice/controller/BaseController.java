package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("v1/catalog")
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/flow")
    @PreAuthorize("")
    public CatalogResponse importFlow(@RequestBody FlowModel dataFlow) {
//        System.out.println("@RequestBody CatalogRequest: " + GsonUtil.convertObjToString(dataFlow));
        return flowService.importFlowDefinition(dataFlow);
    }
    //
    @PostMapping("/flow-version/{flowId}")
    public CatalogResponse importFlowVersion(@RequestBody FlowVersionModel flowVersion, @PathVariable long flowId) {
//        CatalogResponse baseResponse = flowVersionService.importFlowVersion(flowId,flowVersion);
        return flowVersionService.importFlowVersion(flowId,flowVersion);
    }

    @GetMapping("/flows")
    public List<FlowModel> getAllFlow(@RequestParam(name = "pageNumber", required = false)int pageNumber) {
        return flowService.findAll(pageNumber);
    }

    @GetMapping("/flow/{flowId}")
    public FlowModel getFlow(@PathVariable long flowId) {
//        CatalogResponse baseResponse = flowService.findOneByFlowId(flowId);
        return flowService.findOneByFlowId(flowId);
    }

}
