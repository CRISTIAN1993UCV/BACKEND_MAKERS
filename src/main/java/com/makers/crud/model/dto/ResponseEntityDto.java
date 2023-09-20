package com.makers.crud.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseEntityDto {
    Object _embedded;
}
