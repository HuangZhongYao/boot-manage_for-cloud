package org.github.bm.system.converter;

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
@Mapper(componentModel = "spring")
public interface NotificationsConverter {

    NotificationsVO toNotificationsVO(NotificationsEntity entity);

    List<NotificationsVO> toNotificationsListVO(List<NotificationsEntity> entityList);

    NotificationsTargetVO toNotificationsTargetVO(NotificationsTargetEntity entity);

    List<NotificationsTargetVO> toNotificationsTargetListVO(List<NotificationsTargetEntity> entityList);

    NotificationsRecordVO toNotificationsRecordVO(NotificationsRecordEntity entity);

    List<NotificationsRecordVO> toNotificationsRecordVOList(List<NotificationsRecordEntity> entityList);
}
