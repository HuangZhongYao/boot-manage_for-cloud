package org.github.bm.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.base.base.vo.BaseIdAndTimeIdVO;
import org.github.bm.base.enums.GenderEnum;
import org.github.bm.system.vo.ResourcesVO;
import org.github.bm.system.vo.RoleVO;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-15 19:38
 */
@Schema(description = "认证用户信息")
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AuthenticationUserDetailVO extends BaseIdAndTimeIdVO {

    @Serial
    private static final long serialVersionUID = 1668055235809325493L;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

    /**
     * 账号
     */
    @Schema(description = "账号")
    private String account;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private GenderEnum gender;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;

    /**
     * 头像url
     */
    @Schema(description = "头像url")
    private String avatarUrl;

    /**
     * 备注信息
     */
    @Schema(description = "备注信息")
    private String remark;

    /**
     * 最后登录时间
     */
    @Schema(description = "最后登录时间")
    private LocalDateTime lastLoginTime;

    /**
     * 角色列表
     */
    @Schema(description = "角色列表")
    private List<RoleVO> roles = new ArrayList<>();

    /**
     * 权限列表
     */
    @Schema(description = "权限列表")
    private List<ResourcesVO> permissions = new ArrayList<>();
}
