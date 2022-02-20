package com.humana.dhp.eventproc.service.catalogservice.service;


import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;

import java.util.List;

public interface FlowService {
    public BaseResponse importFlowDefinition(FlowModel flow);
    public CatalogResponse findOneByFlowId(long flowId);
    public CatalogResponse findAll(int pageNumber);
}
