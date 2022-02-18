package com.humana.dhp.eventproc.service.catalogservice.serviceImpl;


import com.humana.dhp.eventproc.service.catalogservice.entity.FlowEntity;
import com.humana.dhp.eventproc.service.catalogservice.entity.FlowVersionEntity;
import com.humana.dhp.eventproc.service.catalogservice.model.CatalogResponse;
import com.humana.dhp.eventproc.service.catalogservice.model.FlowVersionModel;
import com.humana.dhp.eventproc.service.catalogservice.repository.FlowVersionRepository;
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
    FlowVersionRepository flowVersionRepository;
    @Autowired
    FlowService flowService;


    @Override
    public CatalogResponse importFlowVersion(FlowVersionModel flowVersionModel) {
        Timestamp flowTimestamp = new Timestamp(System.currentTimeMillis());
        FlowVersionEntity flowVersionEntity = GsonUtil.convert(flowVersionModel, FlowVersionEntity.class);
        System.out.println(flowVersionEntity.getFlow().getFlowId());
//
//        FlowEntity flowEntity = flowService.findOneByFlowId(flowVersionEntity.getFlow().getFlowId());
//        int version = flowVersionEntity.getVersion() + 1;

        flowVersionEntity.setUpdateAt(flowTimestamp);
        flowVersionEntity.setUpdatedBy("abc");

        System.out.println("FlowVersionEntity: " + flowVersionEntity.toString());
        flowVersionRepository.save(flowVersionEntity);
        return ResponseUtil.getSuccess();
    }
}
