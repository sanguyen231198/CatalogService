package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;

import java.util.Optional;

public interface FlowService {
    public CatalogResponse importFlowDefinition(FlowModel flow);
    public CatalogResponse findOneByFlowId(long flowId);
    public CatalogResponse findAll(int pageNumber);
}
