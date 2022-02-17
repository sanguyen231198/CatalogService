package com.humana.dhp.eventproc.service.catalogservice.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flow_version")
@IdClass(FlowVersionId.class)
public class FlowVersionEntity {
/*    @Id
    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumns({
////            @JoinColumn(name="flow_id", nullable=true, referencedColumnName = "") })
//    @JoinColumn(name="flow_id",nullable = false, referencedColumnName="flow_id")
    @JoinColumn(name="flow_id",nullable = false)
    private FlowEntity flow;*/
    @EmbeddedId
    private Pk id;
//    @Id
//    private Integer version;
    private String comment;
    private String content;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name = "updated_by")
    private String updatedBy;

    @Embeddable
    public static class Pk implements Serializable{
        @ManyToOne
        @JoinColumn(name="flow_id")
        private FlowEntity flow;
        private int version;

        public FlowEntity getFlow() {
            return flow;
        }

        public void setFlow(FlowEntity flow) {
            this.flow = flow;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Pk(FlowEntity flow, int version) {
            this.flow = flow;
            this.version = version;
        }

        public Pk() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pk that = (Pk) o;
            return version == that.version && Objects.equals(flow, that.flow);
        }

        @Override
        public int hashCode() {
            return Objects.hash(flow, version);
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FlowVersionEntity that = (FlowVersionEntity) o;
//        return Objects.equals(flow, that.flow) && Objects.equals(version, that.version) && Objects.equals(comment, that.comment) && Objects.equals(content, that.content) && Objects.equals(updateAt, that.updateAt) && Objects.equals(updatedBy, that.updatedBy);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(flow, version, comment, content, updateAt, updatedBy);
//    }
}

class FlowVersionId implements Serializable{
    private FlowEntity flow;
    private int version;

    public FlowVersionId(FlowEntity flow, int version) {
        this.flow = flow;
        this.version = version;
    }

    public FlowVersionId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowVersionId that = (FlowVersionId) o;
        return version == that.version && Objects.equals(flow, that.flow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flow, version);
    }
}


