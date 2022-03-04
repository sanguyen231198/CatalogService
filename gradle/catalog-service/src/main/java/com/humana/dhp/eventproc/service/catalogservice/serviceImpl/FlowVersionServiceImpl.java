package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;

import com.google.gson.reflect.TypeToken;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowVersionRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class FlowVersionServiceImpl implements FlowVersionService {
    @Autowired
    FlowRepository flowRepository;
    @Autowired
    FlowVersionRepository flowVersionRepository;

    @Override
    public APIResponse importFlowVersion(UUID flowId, FlowVersionRequest flowVersionRequest) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        if (flowEntity == null) {
            return ResponseUtil.getMessage("Flow " + flowEntity.getFlowName() + " is not exists");
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
        return ResponseUtil.importFlowVersionSuccess("Import new version to Flow " + flowEntity.getFlowName() + " successfully!", flowEntity.getFlowId(), flowVersionEntity.getVersion());
    }

    @Override
    public APIResponse findAllVersion(UUID flowId, int page, int pageSize) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        if (flowEntity == null) {
            return ResponseUtil.getMessage("FLow not found!!!");
        }
        Page<FlowVersionEntity> flowVersionEntitiesPage;
        List<FlowVersionEntity> flowVersionEntities;
        if (page == 0 && pageSize == 0) {
            return ResponseUtil.getMessage("Page and PageSize not empty");
        }
        flowVersionEntitiesPage = flowVersionRepository.findAllByFlowId(flowId, PageRequest.of(page - 1, pageSize));
        flowVersionEntities = flowVersionEntitiesPage.getContent();
        System.out.println("flowVersionEntities: " + flowVersionEntities);
        flowVersionEntities.stream().forEach(flowVersion -> {
            flowVersion.setFlow(null);
        });
        List<FlowVersionResponse> flowVersionResponses = GsonUtil.convert(flowVersionEntities, new TypeToken<List<FlowVersionResponse>>() {
        });
        return ResponseUtil.getFlowVersionsSuccess(new Pagination(page, pageSize, flowRepository.findAll().size()), flowVersionResponses);
    }

    @Override
    public APIResponse findOneByFlowIdAndVersion(UUID flowId, Integer version) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        if (flowEntity == null) {
            return ResponseUtil.getMessage("FLow not found!!!");
        }
        FlowVersionEntity flowVersionEntity = flowVersionRepository.findOneByFlowIdAndVersion(flowId, version);
        flowEntity.getFlowVersions().stream().forEach(flowVersion -> {
            flowVersion.setFlow(null);
        });
        return ResponseUtil.getFlowVersionSuccess(GsonUtil.convert(flowVersionEntity, FlowDetailVersionResponse.class));
    }
}
