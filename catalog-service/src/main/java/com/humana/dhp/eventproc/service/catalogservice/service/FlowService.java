package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowDetailModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowRequest;

import java.util.List;

public interface FlowService {
    public CatalogResponse importFlowDefinition(FlowRequest flow);
    public FlowDetailModel findOneByFlowId(long flowId);
    public List<FlowModel> findAll(int pageNumber);
}
