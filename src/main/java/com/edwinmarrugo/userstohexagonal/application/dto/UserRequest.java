package com.edwinmarrugo.userstohexagonal.application.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String typeId;
    private String numberId;
    private String name;
}
