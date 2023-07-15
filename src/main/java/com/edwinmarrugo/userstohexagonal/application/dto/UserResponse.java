package com.edwinmarrugo.userstohexagonal.application.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String typeId;
    private String numberId;
    private String name;
}
