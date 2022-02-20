package com.humana.dhp.eventproc.service.catalogservice.repository;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowRepository extends JpaRepository<FlowEntity,Long> {
    FlowEntity findOneByFlowId(long flowId);
    FlowEntity findOneByFlowName(String flowName);
}
