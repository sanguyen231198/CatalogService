package com.humana.dhp.eventproc.service.catalogservice.service;

import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionRequest;

public interface FlowVersionService {
    public BaseResponse importFlowVersion(long flowId, FlowVersionRequest flowVersionRequest);
}
