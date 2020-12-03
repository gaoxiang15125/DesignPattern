package org.study.design.design.templateoattern.jdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: design
 * @description: 实体类对象
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2020-11-29 21:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    // 姓名 密码 昵称
    private String userName;
    private String password;
    private String nickName;

    // 年龄 住址
    private int age;
    private String addr;
}
