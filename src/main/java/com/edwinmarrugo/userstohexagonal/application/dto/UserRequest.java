package com.edwinmarrugo.userstohexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Builder
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String typeId;
    private String numberId;
    private String name;
}
