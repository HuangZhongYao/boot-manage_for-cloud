package org.github.bm.system.converter;

import org.github.bm.common.base.convert.AbstractConvert;
import org.github.bm.system.entity.DictDataEntity;
import org.github.bm.system.vo.DictDataVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @org.mapstruct.Builder(disableBuilder = true))
// disableBuilder禁用Builder构建器否则父类属性无法赋值
public interface DictDataConvert extends AbstractConvert<DictDataEntity, DictDataVO> {
}
