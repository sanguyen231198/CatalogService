package com.humana.dhp.eventproc.service.catalogservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowModel {
    private long flowId;
    private String flowName;
    private String description;
    private Timestamp updateAt;
    private String updatedBy;
    private int countVersion;
    private FlowVersionModel flowVersion;
    private Set<FlowVersionModel> flowVersions;

}




