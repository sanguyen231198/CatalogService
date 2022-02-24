package com.humana.dhp.eventproc.service.catalogservice.service;

import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionRequest;

public interface FlowVersionService {
    public CatalogResponse importFlowVersion(long flowId, FlowVersionRequest flowVersionRequest);
}
