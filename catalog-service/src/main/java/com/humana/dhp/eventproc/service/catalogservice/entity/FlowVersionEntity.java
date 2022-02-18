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
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="flow_id",nullable = false)
    private FlowEntity flow;
//    @EmbeddedId
//    private Pk id;
    @Id
    private int version;
    private String comment;
    private String content;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name = "updated_by")
    private String updatedBy;

    @Override
    public String toString() {
        return "FlowVersionEntity{" +
                "version=" + version +
                ", comment='" + comment + '\'' +
                ", content='" + content + '\'' +
                ", updateAt=" + updateAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }

    //    @Embeddable
//    public static class Pk implements Serializable{
//        @ManyToOne
//        @JoinColumn(name="flow_id")
//        private FlowEntity flow;
//        private int version;
//
//        public FlowEntity getFlow() {
//            return flow;
//        }
//
//        public void setFlow(FlowEntity flow) {
//            this.flow = flow;
//        }
//
//        public int getVersion() {
//            return version;
//        }
//
//        public void setVersion(int version) {
//            this.version = version;
//        }
//
//        public Pk(FlowEntity flow, int version) {
//            this.flow = flow;
//            this.version = version;
//        }
//
//        public Pk() {
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Pk that = (Pk) o;
//            return version == that.version && Objects.equals(flow, that.flow);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(flow, version);
//        }
//    }


}
@AllArgsConstructor
@NoArgsConstructor
class FlowVersionId implements Serializable{
    private FlowEntity flow;
    private int version;

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


