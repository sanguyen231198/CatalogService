package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowDetailResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowRequest;

import java.util.List;

public interface FlowService {
    public BaseResponse importFlowDefinition(FlowRequest flow);
    public FlowDetailResponse findOneByFlowId(long flowId);
    public List<FlowResponse> findAll(int pageNumber);
}
