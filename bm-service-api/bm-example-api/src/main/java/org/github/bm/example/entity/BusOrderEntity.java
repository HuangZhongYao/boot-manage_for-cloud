package org.github.bm.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.github.bm.common.base.entity.AbstractBaseEntity;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 * 商城订单表实体
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 10:03:05
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("bus_order")
public class BusOrderEntity extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -1;

        /**
     * 订单号
     */
    private String orderNo;

        /**
     * 商品
     */
    private String commodity;

        /**
     * 下单时间
     */
    private LocalDateTime orderTime;

        /**
     * 收货地址
     */
    private String address;

        /**
     * 收货人
     */
    private String consignee;

        /**
     * 收货人电话
     */
    private String consigneePhone;

        /**
     * 支付状态
     */
    private Byte payState;

    }

