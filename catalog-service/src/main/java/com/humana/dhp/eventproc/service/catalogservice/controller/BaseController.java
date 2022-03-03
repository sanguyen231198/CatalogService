package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/catalog")
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/flows")
    public BaseResponse importFlow(@RequestBody FlowRequest dataFlow) {
        return flowService.importFlowDefinition(dataFlow);
    }

    @PostMapping("/flow-versions/{flowId}")
    public BaseResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersion, @PathVariable long flowId) {
        return flowVersionService.importFlowVersion(flowId, flowVersion);
    }

    @GetMapping("/flows")
    public List<FlowResponse> getAllFlow(@RequestParam(name = "pageNumber", required = false) Optional<String> pageNumber) {
        try {
            String pageNum = pageNumber.orElse("0");
            int page = Integer.valueOf(pageNum);
            return flowService.findAll(page);
        } catch (Exception ex) {
            //log ex
            return Collections.emptyList();
        }
    }

    @GetMapping("/flows/{flowId}")
    public FlowDetailResponse getFlow(@PathVariable long flowId) {
        return flowService.findOneByFlowId(flowId);
    }

}
