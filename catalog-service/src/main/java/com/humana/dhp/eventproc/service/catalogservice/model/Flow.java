package com.humana.dhp.eventproc.service.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "flow")
public class Flow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flow_id")
    private long flowId;
    @Column(name = "flow_name")
    private String flowName;
    @Column(name = "flow_description")
    private String flowDescription;
    @OneToMany(mappedBy = "flow", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<FlowVersion> flowVersions;
}




