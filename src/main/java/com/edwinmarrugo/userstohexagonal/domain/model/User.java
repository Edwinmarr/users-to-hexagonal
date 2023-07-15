package com.edwinmarrugo.userstohexagonal.domain.model;

import java.util.List;

public class User {
    private String typeId;
    private String numberId;
    private String name;

    public User() {
    }

    public User(String typeId, String numberId, String name) {
        this.typeId = typeId;
        this.numberId = numberId;
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
