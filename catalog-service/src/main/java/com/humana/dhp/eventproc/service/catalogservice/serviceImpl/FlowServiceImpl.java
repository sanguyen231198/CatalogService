package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;

import com.google.gson.reflect.TypeToken;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowDetailModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowRequest;
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

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    FlowRepository flowRepository;
    @Value("${page.number}")
    private int pageNumberConfig;

    @Override
    public CatalogResponse importFlowDefinition(FlowRequest flowRequest) {
        //prevent update flow => set flowId =0
//        flowModel.setFlowId(0);
        //validate input
        FlowEntity flowEntity = flowRepository.findOneByFlowName(flowRequest.getFlowName());
        if (flowEntity != null) {
            return ResponseUtil.getFailed("DataFlow already exists");
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
        System.out.println("FlowVersionEntity: " + flowVersionEntity.toString());

        flowEntity.getFlowVersions().add(flowVersionEntity);
        flowRepository.save(flowEntity);
        return ResponseUtil.getSuccess("DataFlow import successfully");

    }

    @Override
    public FlowDetailModel findOneByFlowId(long flowId) {
        FlowEntity flowEntity = flowRepository.findOneByFlowId(flowId);
        flowEntity.getFlowVersions().stream().forEach(version -> {
            version.setFlow(null);
        });
        return GsonUtil.convert(flowEntity, FlowDetailModel.class);
    }

    @Override
    public List<FlowModel> findAll(int pageNumber) {
        pageNumber--;
        Page<FlowEntity> flowEntitiesPage = flowRepository.findAll(PageRequest.of(pageNumber, pageNumberConfig));
        List<FlowEntity> flowEntities = flowEntitiesPage.getContent();
        flowEntities.stream().forEach(flow -> {
            flow.setFlowVersions(null);
        });
        return GsonUtil.convert(flowEntities, new TypeToken<List<FlowModel>>() {
        });
    }


}
