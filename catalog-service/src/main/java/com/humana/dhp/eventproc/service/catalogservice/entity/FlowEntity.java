package com.humana.dhp.eventproc.service.catalogservice.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "flow")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FlowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flow_id")
    private long flowId;
    @Column(name = "flow_name")
    private String flowName;
    private String description;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "flow",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FlowVersionEntity> flowVersions = new HashSet<>();

//    public Set<FlowVersionEntity> getFlowVersions() {
//        return flowVersions;
//    }
//
//    public void setFlowVersions(Set<FlowVersionEntity> flowVersions) {
//        this.flowVersions = flowVersions;
//    }
}




