package com.humana.dhp.eventproc.service.catalogservice.controller;

import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/catalog")
public class BaseController {
    @Autowired
    FlowService flowService;
    @Autowired
    FlowVersionService flowVersionService;

    @PostMapping("/flows")
    public APIResponse importFlow(@RequestBody FlowRequest dataFlow) {
        return flowService.importFlowDefinition(dataFlow);
    }

    @GetMapping("/flows")
    public APIResponse getFlows(@RequestParam(required = false) Optional<String> page, @RequestParam(required = false) Optional<String> pageSize) {
        try {
            String pageNum = page.orElse("0");
            String pageSizeNum = pageSize.orElse("0");
            int pageNumber = Integer.parseInt(pageNum);
            int pageSizeNumber = Integer.parseInt(pageSizeNum);
            if (pageNumber <= -1) {
                ResponseUtil.getMessage("Page must be a positive integer");
            }
            if (pageSizeNumber <= -1) {
                ResponseUtil.getMessage("PageSize must be a positive integer");
            }
            return flowService.findAll(pageNumber, pageSizeNumber);
        } catch (Exception ex) {
            return ResponseUtil.getMessage("Page and PageSize must be a positive integer");
        }

    }

    @GetMapping("/flows/{flowId}")
    public APIResponse getFlow(@PathVariable UUID flowId) {
        return flowService.findOneByFlowId(flowId);
    }

    @PostMapping("/flow-versions/{flowId}")
    public APIResponse importFlowVersion(@RequestBody FlowVersionRequest flowVersion, @PathVariable UUID flowId) {
        return flowVersionService.importFlowVersion(flowId, flowVersion);
    }

    @GetMapping("/flow-versions/{flowId}")
    public APIResponse getFlowVersions(@PathVariable UUID flowId, @RequestParam(required = false) Optional<String> page, @RequestParam(required = false) Optional<String> pageSize) {
        try {
            String pageNum = page.orElse("0");
            String pageSizeNum = pageSize.orElse("0");
            int pageNumber = Integer.parseInt(pageNum);
            int pageSizeNumber = Integer.parseInt(pageSizeNum);
            if (pageNumber <= -1) {
                ResponseUtil.getMessage("Page must be a positive integer");
            }
            if (pageSizeNumber <= -1) {
                ResponseUtil.getMessage("PageSize must be a positive integer");
            }
            return flowVersionService.findAllVersion(flowId, pageNumber, pageSizeNumber);
        } catch (Exception ex) {
            return ResponseUtil.getMessage("Page and PageSize must be a positive integer");
        }
    }

    @GetMapping("/flow-versions/{flowId}/{version}")
    public APIResponse getFlowVersion(@PathVariable UUID flowId, @PathVariable Integer version){
        return flowVersionService.findOneByFlowIdAndVersion(flowId,version);
    }
}
