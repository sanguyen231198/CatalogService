package com.humana.dhp.eventproc.service.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse {
    private String responseCode;
    private String responseDescription;
}
