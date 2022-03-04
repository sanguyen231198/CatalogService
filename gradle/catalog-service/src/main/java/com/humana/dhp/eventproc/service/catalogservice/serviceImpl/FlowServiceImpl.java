package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;

import com.google.gson.reflect.TypeToken;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.*;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    FlowRepository flowRepository;

    @Override
    public APIResponse importFlowDefinition(FlowRequest flowRequest) {
        FlowEntity flowEntity = flowRepository.findOneByFlowName(flowRequest.getFlowName());
        if (flowEntity != null) {
            return ResponseUtil.getMessage("DataFlow already exists");
        }
        flowEntity = GsonUtil.convert(flowRequest, FlowEntity.class);
        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
        flowEntity.setCreatedAt(flowTimestamp);
        flowEntity.setCountVersion(1);
        flowEntity.setUpdateAt(flowTimestamp);
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        flowEntity.setCreatedBy(securityContext.getAuthentication().getName());
//        flowEntity.setUpdatedBy(securityContext.getAuthentication().getName());

        FlowVersionEntity flowVersionEntity = GsonUtil.convert(flowRequest.getDataFlow(), FlowVersionEntity.class);
        flowVersionEntity.setVersion(1);
        flowVersionEntity.setUpdateAt(flowTimestamp);
//        flowVersionEntity.setUpdatedBy(securityContext.getAuthentication().getName());
        flowVersionEntity.setFlow(flowEntity);
        flowEntity.getFlowVersions().add(flowVersionEntity);
        flowRepository.save(flowEntity);
        return ResponseUtil.importFlowSuccess("DataFlow import successfully", flowEntity.getFlowId());

    }

    @Override
    public APIResponse findOneByFlowId(UUID flowId) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        if (flowEntity == null) {
            return ResponseUtil.getMessage("FLow not found!!!");
        }
        flowEntity.getFlowVersions().stream().forEach(version -> {
            version.setFlow(null);
        });
        return ResponseUtil.getFlowSuccess(GsonUtil.convert(flowEntity, FlowDetailResponse.class));
    }

    @Override
    public APIResponse findAll(int page, int pageSize) {
        Page<FlowEntity> flowEntitiesPage;
        List<FlowEntity> flowEntities;
        if (page == 0 && pageSize == 0) {
            return ResponseUtil.getMessage("Page and PageSize not empty");
        }
        flowEntitiesPage = flowRepository.findAll(PageRequest.of(page - 1, pageSize));
        flowEntities = flowEntitiesPage.getContent();

        flowEntities.stream().forEach(flow -> {
            flow.setFlowVersions(null);
        });
        List<FlowResponse> flowResponses = GsonUtil.convert(flowEntities, new TypeToken<List<FlowResponse>>() {
        });
        return ResponseUtil.getFlowsSuccess(new Pagination(page, pageSize, flowRepository.findAll().size()), flowResponses);
    }

}
