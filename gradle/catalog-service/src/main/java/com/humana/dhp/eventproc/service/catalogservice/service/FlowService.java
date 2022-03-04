package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.APIResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowDetailResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowRequest;

import java.util.List;
import java.util.UUID;

public interface FlowService {
    public APIResponse importFlowDefinition(FlowRequest flow);
    public APIResponse findOneByFlowId(UUID flowId);
    public APIResponse findAll(int page, int pageSize);
}
