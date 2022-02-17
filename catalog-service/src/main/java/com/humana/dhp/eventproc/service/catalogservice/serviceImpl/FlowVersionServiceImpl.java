package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;


import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowVersionRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowVersionServiceImpl implements FlowVersionService {
    @Autowired
    FlowVersionRepository flowVersionRepository;
    @Override
    public FlowVersionEntity createFlowVersion(FlowVersionEntity flowVersion) {
        return flowVersionRepository.save(flowVersion);
    }
}
