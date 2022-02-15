package com.humana.dhp.eventproc.service.catalogservice.model;

import javax.persistence.*;

@Entity
@Table(name = "flow_version")
public class FlowVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name="flow_id", nullable=false)
    private Flow flow;
    private String version;
    private String comment;
    private String flow_content;

    public FlowVersion() {
    }

    public FlowVersion(Flow flow, String version, String comment, String flow_content) {
        this.flow = flow;
        this.version = version;
        this.comment = comment;
        this.flow_content = flow_content;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFlow_content() {
        return flow_content;
    }

    public void setFlow_content(String flow_content) {
        this.flow_content = flow_content;
    }
}
