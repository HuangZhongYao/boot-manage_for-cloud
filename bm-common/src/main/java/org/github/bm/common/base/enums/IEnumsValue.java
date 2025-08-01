package org.github.bm.common.base.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * 枚举属性字段基类
 * @Desc 枚举基类
 * @Time 2024-07-11 14:58
 * @Author HuangZhongYao
 */
public interface IEnumsValue extends IEnum<Integer> {

    /**
     * 获取枚举value 需要确保该值在枚举中是唯一的,value对应数据库存储字段
     *
     * @return 枚举唯一value值
     */
    Integer getValue();
}
