package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;


import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowModel;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowRepository;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowService;
import com.humana.dhp.eventproc.service.catalogservice.service.FlowVersionService;
import com.humana.dhp.eventproc.service.catalogservice.utils.GsonUtil;
import com.humana.dhp.eventproc.service.catalogservice.utils.ResponseUtil;
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
    public CatalogResponse importFlowDefinition(FlowModel flowModel) {
        System.out.println("importFlowDefinition: "+GsonUtil.convertObjToString(flowModel));
        FlowEntity flowEntity = GsonUtil.convert(flowModel, FlowEntity.class);
        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
        flowEntity.setCreatedAt(flowTimestamp);
        flowEntity.setUpdateAt(flowTimestamp);
        flowEntity.setCreatedBy("abc");
        flowEntity.setUpdatedBy("abc");
        Set<FlowVersionEntity> flowVersionEntities = new HashSet<>();
        FlowVersionEntity flowVersionEntity = GsonUtil.convert(flowModel.getFlowVersion(),FlowVersionEntity.class);
        FlowVersionEntity.Pk pk = flowVersionEntity.getId();
        pk.setVersion(1);
//        flowVersionEntity.setVersion(1);
        flowVersionEntity.setId(pk);
        flowVersionEntities.add(flowVersionEntity);
        flowEntity.setFlowVersions(flowVersionEntities);
        System.out.println(GsonUtil.convertObjToString(flowEntity));
        flowRepository.save(flowEntity);
        return ResponseUtil.getSuccess();
//        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
//        flow.setCreatedAt(flowTimestamp);
//        flow.setUpdateAt(flowTimestamp);
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
//        return flowRepository.save(flow);
    }


}
