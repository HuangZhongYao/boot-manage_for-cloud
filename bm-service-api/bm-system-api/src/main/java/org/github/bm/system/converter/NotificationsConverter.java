package org.github.bm.system.converter;

import org.github.bm.system.entity.NotificationsEntity;
import org.github.bm.system.entity.NotificationsTargetEntity;
import org.github.bm.system.vo.NotificationsTargetVO;
import org.github.bm.system.vo.NotificationsVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Time 2025-08-28 17:02
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */
@Mapper(componentModel = "spring")
public interface NotificationsConverter {

    NotificationsVO toNotificationsVO(NotificationsEntity entity);

    List<NotificationsVO> toNotificationsListVO(List<NotificationsEntity> entity);

    NotificationsTargetVO toNotificationsTargetVO(NotificationsTargetEntity entity);

    List<NotificationsTargetVO> toNotificationsTargetListVO(List<NotificationsTargetEntity> entity);
}
