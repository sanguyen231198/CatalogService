package com.humana.dhp.eventproc.service.catalogservice.repository;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowVersionRepository extends JpaRepository<FlowVersionEntity,Long> {
}
