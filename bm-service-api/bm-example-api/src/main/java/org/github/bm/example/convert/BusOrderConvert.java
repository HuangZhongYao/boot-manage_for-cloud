package org.github.bm.example.convert;

import org.mapstruct.Mapper;

/**
 * Time 2025-09-17 10:00
 * CreatedBy IntelliJ IDEA By HuangZhongYao
 */

// 最好禁用disableBuilder 否则可能父类属性无法赋值
@Mapper(componentModel = "spring", builder = @org.mapstruct.Builder(disableBuilder = true))
public interface BusOrderConvert {
}
