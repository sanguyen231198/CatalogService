package com.humana.dhp.eventproc.service.catalogservice.repository;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowVersionRepository extends JpaRepository<FlowVersionEntity,Long> {
}
