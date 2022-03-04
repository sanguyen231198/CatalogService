package com.humana.dhp.eventproc.service.catalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowDetailResponse {
    private UUID flowId;
    private String flowName;
    private String description;
    private Timestamp updateAt;
    private String updatedBy;
}
