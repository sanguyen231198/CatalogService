package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/catalog")
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/flow")
    @PreAuthorize("hasRole('ROLE_USER')")
    public BaseResponse importFlow(@RequestBody FlowRequest dataFlow) {
        return flowService.importFlowDefinition(dataFlow);
    }

    @PostMapping("/flow-version/{flowId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public BaseResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersion, @PathVariable long flowId) {

        return flowVersionService.importFlowVersion(flowId, flowVersion);
    }

    @GetMapping("/flows")
    @PreAuthorize("hasRole('ROLE_USER')")
    public BaseResponse getAllFlow(@RequestParam(name = "pageNumber", required = false) Optional<String> pageNumber) {

        try {
            String pageNum = pageNumber.orElse("0");
            int page = Integer.parseInt(pageNum);
            if (page <= -1) {
                ResponseUtil.getFailed("Param pageNum must be a positive integer");
            }
            BaseResponse catalogResponse = new BaseResponse();
            catalogResponse.setDataFlows(flowService.findAll(page));
            return catalogResponse;
        } catch (Exception ex) {
            return ResponseUtil.getFailed("Param pageNum must be a positive integer");
        }

    }

    @GetMapping("/flow")
    @PreAuthorize("hasRole('ROLE_USER')")
    public FlowDetailResponse getFlow(@RequestParam Optional<String> flowId) {
        try {
            String requestId = flowId.orElse("0");
            long id = Long.parseLong(requestId);
            return flowService.findOneByFlowId(id);

        } catch (Exception ex) {
            return null;
        }
    }

}
