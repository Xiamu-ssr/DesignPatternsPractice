package org.dragon.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户基本信息
 *
 * @author mumu
 * @date 2024/06/08
 */
@Data
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private UserRole role;
}
