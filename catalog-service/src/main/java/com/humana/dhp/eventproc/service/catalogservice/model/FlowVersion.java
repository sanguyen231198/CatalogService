package com.humana.dhp.eventproc.service.catalogservice.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @Column(name = "flow_content")
    private String flowContent;


}
