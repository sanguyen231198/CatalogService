package com.humana.dhp.eventproc.service.catalogservice.service;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.BaseResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionModel;

public interface FlowVersionService {
    public BaseResponse importFlowVersion(long flowId, FlowVersionModel flowVersionModel);
}
