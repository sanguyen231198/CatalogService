package com.humana.dhp.eventproc.service.catalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogResponse {
    private String responseCode;
    private String responseDescription;
    private FlowModel dataFlow;
    private List<FlowModel> dataFlows;

}
