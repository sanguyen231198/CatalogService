package com.humana.dhp.eventproc.service.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatalogResponse {
    private String responseCode;
    private String responseDescription;
    private FlowModel dataFlow;
    private FlowVersionModel flowVersionModel;

    public CatalogResponse(String responseCode, String responseDescription, FlowModel dataFlow) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.dataFlow = dataFlow;
    }

    public CatalogResponse(String responseCode, String responseDescription, FlowVersionModel flowVersionModel) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.flowVersionModel = flowVersionModel;
    }
}
