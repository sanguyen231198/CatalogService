package com.humana.dhp.eventproc.service.catalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class FlowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flow_id")
    private Long flowId;
    @Column(name = "flow_name")
    private String flowName;
    private String description;
    @Column(name = "version_count")
    private String versionCount;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "id.flow",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FlowVersionEntity> flowVersions = new HashSet<>();




}




