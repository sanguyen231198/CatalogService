package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;


import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersion;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowVersionRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FlowVersionServiceImpl implements FlowVersionService {
    @Autowired
    FlowVersionRepository flowVersionRepository;
    @Override
    public FlowVersion createFlowVersion(FlowVersion flowVersion) {
        return flowVersionRepository.save(flowVersion);
    }
}
