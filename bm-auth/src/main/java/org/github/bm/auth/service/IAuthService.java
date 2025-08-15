package org.github.bm.auth.service;

import org.github.bm.auth.dto.LoginDTO;
import org.github.bm.auth.vo.AuthenticationUserDetailVO;
import org.github.bm.common.security.AuthInfo;
import org.github.bm.system.vo.ResourcesTreeVo;

import java.util.List;

public interface IAuthService {
    AuthInfo login(LoginDTO loginDTO, String client);

    Boolean loginOut(String client);

    AuthInfo refreshToken(String refreshToken, String client);

    List<ResourcesTreeVo> queryPermissionsTree();

    String captcha();

    AuthenticationUserDetailVO authenticationUserDetail();
}
