package com.humana.dhp.eventproc.service.catalogservice.model;

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
@Embeddable
public class Flow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flow_id")
    private long flowId;
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

    @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<FlowVersion> flowVersions = new HashSet<>();

//    public void addFirstVersion(FlowVersion flowVersion){
//        flowVersions.add(flowVersion);
//        flowVersion.setFlow(this);
//    }


}




