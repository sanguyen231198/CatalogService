package com.humana.dhp.eventproc.service.catalogservice.repository;

import com.humana.dhp.eventproc.service.catalogservice.model.Flow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowRepository extends JpaRepository<Flow,Long> {
}
