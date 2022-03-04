package com.humana.dhp.eventproc.service.catalogservice.service;

import com.humana.dhp.eventproc.service.catalogservice.model.APIResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionRequest;

import java.util.UUID;

public interface FlowVersionService {
    public APIResponse importFlowVersion(UUID flowId, FlowVersionRequest flowVersionRequest);
    public APIResponse findAllVersion(UUID flowId,int page, int pageSize);

    public APIResponse findOneByFlowIdAndVersion(UUID flowId, Integer version);
}
