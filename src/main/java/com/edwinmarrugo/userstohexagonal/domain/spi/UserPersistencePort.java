package com.edwinmarrugo.userstohexagonal.domain.spi;

import com.edwinmarrugo.userstohexagonal.domain.model.User;

public interface UserPersistencePort {
    void saveUser(User user);

    User getUser(String typeId, String numberId);
}
