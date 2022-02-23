package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FlowService {
    public CatalogResponse importFlowDefinition(FlowModel flow);
    public FlowModel findOneByFlowId(long flowId);
    public List<FlowModel> findAll(int pageNumber);
}
