package com.humana.dhp.eventproc.service.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CatalogRequest {
    private String requestId;
    private String requestTime;
    private FlowModel dataFlow;
    private FlowVersionModel flowVersionModel;

    public CatalogRequest(String requestId, String requestTime, FlowModel dataFlow) {
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.dataFlow = dataFlow;
    }

    public CatalogRequest(String requestId, String requestTime, FlowVersionModel flowVersionModel) {
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.flowVersionModel = flowVersionModel;
    }
}
