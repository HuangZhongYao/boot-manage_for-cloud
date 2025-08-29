package org.github.bm.system.converter;

import org.github.bm.system.dto.AddNotificationsInputDTO;
import org.github.bm.system.dto.EditNotificationsInputDTO;
import org.github.bm.system.dto.NotificationsTargetInputDTO;
import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.entity.NotificationsRecordEntity;
import org.github.bm.system.entity.NotificationsTargetEntity;
import org.github.bm.system.vo.NotificationsRecordVO;
import org.github.bm.system.vo.NotificationsTargetVO;
import org.github.bm.system.vo.NotificationsVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-28 17:02
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring",builder = @org.mapstruct.Builder(disableBuilder = true)) // disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface NotificationsConverter {

    NotificationsVO toNotificationsVO(NotificationsEntity entity);

    List<NotificationsVO> toNotificationsListVO(List<NotificationsEntity> entityList);

    NotificationsTargetVO toNotificationsTargetVO(NotificationsTargetEntity entity);

    List<NotificationsTargetVO> toNotificationsTargetListVO(List<NotificationsTargetEntity> entityList);

    NotificationsRecordVO toNotificationsRecordVO(NotificationsRecordEntity entity);

    List<NotificationsRecordVO> toNotificationsRecordVOList(List<NotificationsRecordEntity> entityList);

    NotificationsEntity toEntity(AddNotificationsInputDTO inputDTO);

    NotificationsEntity toEntity(EditNotificationsInputDTO inputDTO);

    List<NotificationsTargetEntity> toNotificationsTargetEntityList(List<NotificationsTargetInputDTO> notificationsTargetDTOList);
}
