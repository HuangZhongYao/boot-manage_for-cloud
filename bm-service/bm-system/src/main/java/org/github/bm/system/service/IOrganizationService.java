package org.github.bm.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.github.bm.common.base.dto.input.BaseManyLongIdInputDTO;
import org.github.bm.system.dto.AddOrganizationInputDTO;
import org.github.bm.system.dto.EditOrganizationInputDTO;
import org.github.bm.system.dto.OrganizationPageQueryInputDTO;
import org.github.bm.system.vo.OrganizationVO;

public interface IOrganizationService {
    Page<OrganizationVO> pageQueryList(OrganizationPageQueryInputDTO inputDTO);

    Boolean addOrganization(AddOrganizationInputDTO inputDTO);

    Boolean editOrganization(EditOrganizationInputDTO inputDTO);

    Boolean delOrganization(BaseManyLongIdInputDTO inputDTO);
}
