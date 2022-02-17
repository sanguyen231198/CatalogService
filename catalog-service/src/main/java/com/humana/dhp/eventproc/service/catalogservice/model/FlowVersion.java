package com.humana.dhp.eventproc.service.catalogservice.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flow_version")
public class FlowVersion implements Serializable {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="flow_id", nullable=false)
    private Flow flow;
    @Id
    private int version;
    private String comment;
    private String content;
    @Column(name = "updated_at")
    private Timestamp updateAt;
    @Column(name = "updated_by")
    private String updatedBy;


}
