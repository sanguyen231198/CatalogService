package com.humana.dhp.eventproc.service.catalogservice.utils;

import com.humana.dhp.eventproc.service.catalogservice.model.*;

import java.util.List;
import java.util.UUID;

public class ResponseUtil {

    public static APIResponse getMessage(String message) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(message);
        return apiResponse;
    }
    public static APIResponse importFlowSuccess(String message, UUID flowId){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(message);
        apiResponse.setFlowId(flowId);
        return apiResponse;
    }
    public static APIResponse getFlowsSuccess(Pagination pagination, List<FlowResponse> datas){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setPagination(pagination);
        apiResponse.setDataFlows(datas);
        return apiResponse;
    }
    public static APIResponse getFlowSuccess(FlowDetailResponse flowDetailResponse){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setDataFlow(flowDetailResponse);
        return apiResponse;
    }
    public static APIResponse importFlowVersionSuccess(String message, UUID flowId, int version) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(message);
        apiResponse.setFlowId(flowId);
        apiResponse.setVersion(version);
        return apiResponse;
    }
    public static APIResponse getFlowVersionsSuccess(Pagination pagination, List<FlowVersionResponse> datas){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setPagination(pagination);
        apiResponse.setData(datas);
        return apiResponse;
    }
    public static APIResponse getFlowVersionSuccess(FlowDetailVersionResponse flowVersion){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setFlowVersion(flowVersion);
        return apiResponse;
    }
}
