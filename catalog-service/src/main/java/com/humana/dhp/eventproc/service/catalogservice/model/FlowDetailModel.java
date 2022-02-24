package com.humana.dhp.eventproc.service.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlowDetailModel {
    private long flowId;
    private String flowName;
    private String description;
    private Timestamp updateAt;
    private String updatedBy;
    private int countVersion;
    private Set<FlowVersionModel> flowVersions;
}
