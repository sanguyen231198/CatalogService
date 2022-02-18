package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;


import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    FlowRepository flowRepository;

    @Override
    public CatalogResponse importFlowDefinition(FlowModel flowModel) {
        System.out.println("importFlowDefinition: " + GsonUtil.convertObjToString(flowModel));
        FlowEntity flowEntity = GsonUtil.convert(flowModel, FlowEntity.class);
        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
        flowEntity.setCreatedAt(flowTimestamp);
        flowEntity.setUpdateAt(flowTimestamp);
        flowEntity.setCreatedBy("abc");
        flowEntity.setUpdatedBy("abc");

        FlowVersionEntity flowVersionEntity = GsonUtil.convert(flowModel.getFlowVersion(), FlowVersionEntity.class);
        flowVersionEntity.setVersion(1);
        flowVersionEntity.setUpdateAt(flowTimestamp);
        flowVersionEntity.setUpdatedBy("abc");
        flowVersionEntity.setFlow(flowEntity);
        System.out.println("FlowVersionEntity: " + flowVersionEntity.toString());

        flowEntity.getFlowVersions().add(flowVersionEntity);
        flowRepository.save(flowEntity);
        return ResponseUtil.getSuccess();

    }


}
