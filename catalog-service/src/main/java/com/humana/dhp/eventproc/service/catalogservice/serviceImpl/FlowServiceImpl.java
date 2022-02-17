package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;

import com.humana.dhp.eventproc.service.catalogservice.model.Flow;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersion;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    FlowRepository flowRepository;
    @Autowired
    FlowVersionService flowVersionService;


    @Override
    public Flow importFlowDefinition(Flow flow) {
//        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
//        flow.setCreatedTimestamp(flowTimestamp);
//        flow.setModifiedTimestamp(flowTimestamp);
//        Set<FlowVersion> flowVersions = new HashSet<>();
//        FlowVersion flowVersion = new FlowVersion();
//        flowVersion.setComment("Initial version");
//        flowVersion.setDeploymentCount(0);
//        flowVersion.setVersion(1);
//        flow.addFirstVersion(flowVersion);
//        flowVersion.setFlow(flow);
//        Timestamp flowVersionTimestamp = new Timestamp(System.currentTimeMillis());
//        flowVersion.setTimestamp(flowVersionTimestamp);
//        flowVersions.add(flowVersionService.createFlowVersion(flowVersion));
//        flow.setFlowVersions(flowVersions);
        return flowRepository.save(flow);
    }
}
