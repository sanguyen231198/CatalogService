package com.humana.dhp.eventproc.service.catalogservice.repository;

import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowVersionRepository extends JpaRepository<FlowVersion,Long> {
}
