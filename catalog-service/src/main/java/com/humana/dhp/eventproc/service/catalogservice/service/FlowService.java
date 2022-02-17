package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;

public interface FlowService {
    public CatalogResponse importFlowDefinition(FlowModel flow);
}
