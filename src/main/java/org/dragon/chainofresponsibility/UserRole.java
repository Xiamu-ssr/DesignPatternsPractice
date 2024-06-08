package org.dragon.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("管理员"),
    CONSUMER("普通用户"),
    GUEST("访客，临时用户");

    private String description;
}
