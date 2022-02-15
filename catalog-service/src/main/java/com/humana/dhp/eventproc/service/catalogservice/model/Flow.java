package com.humana.dhp.eventproc.service.catalogservice.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "flow")
public class Flow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flow_id;
    private String flow_name;
    private String flow_description;
    @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<FlowVersion> flowVersions;


    public Flow() {
    }

    public Flow(long flow_id, String flow_name, String flow_description, Set<FlowVersion> flowVersions) {
        this.flow_id = flow_id;
        this.flow_name = flow_name;
        this.flow_description = flow_description;
        this.flowVersions = flowVersions;
    }

    public long getFlow_id() {
        return flow_id;
    }

    public void setFlow_id(long flow_id) {
        this.flow_id = flow_id;
    }

    public String getFlow_name() {
        return flow_name;
    }

    public void setFlow_name(String flow_name) {
        this.flow_name = flow_name;
    }

    public String getFlow_description() {
        return flow_description;
    }

    public void setFlow_description(String flow_description) {
        this.flow_description = flow_description;
    }

    public Set<FlowVersion> getFlowVersions() {
        return flowVersions;
    }

    public void setFlowVersions(Set<FlowVersion> flowVersions) {
        this.flowVersions = flowVersions;
    }
}
