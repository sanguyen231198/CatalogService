package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;

import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionRequest;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FlowVersionServiceImpl implements FlowVersionService {
    @Autowired
    FlowRepository flowRepository;
    @Autowired
    FlowService flowService;

    @Override
    public CatalogResponse importFlowVersion(long flowId, FlowVersionRequest flowVersionRequest) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        if (flowEntity == null) {
            return ResponseUtil.getFailed("Flow " + flowEntity.getFlowName() + " is not exists");
        }
        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
        FlowVersionEntity flowVersionEntity = GsonUtil.convert(flowVersionRequest, FlowVersionEntity.class);
        int version = flowEntity.getFlowVersions().size() + 1;
        flowVersionEntity.setVersion(version);
        flowVersionEntity.setUpdateAt(flowTimestamp);
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        flowVersionEntity.setUpdatedBy(securityContext.getAuthentication().getName());
        flowVersionEntity.setFlow(flowEntity);
        flowEntity.getFlowVersions().add(flowVersionEntity);
        flowEntity.setCountVersion(version);
        flowRepository.save(flowEntity);
        return ResponseUtil.getSuccess("Import new version to Flow " + flowEntity.getFlowName() + " successfully!");
    }
}
