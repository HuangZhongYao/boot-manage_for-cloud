package org.github.bm.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.dto.BaseDTO;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 商城订单表新增数据DTO对象
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 10:03:05
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class AddBusOrderInputDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = -1;


        /**
     * 订单号
     */
    @Schema(description = "订单号")
    private String orderNo;

        /**
     * 商品
     */
    @Schema(description = "商品")
    private String commodity;

        /**
     * 下单时间
     */
    @Schema(description = "下单时间")
    private LocalDateTime orderTime;

        /**
     * 收货地址
     */
    @Schema(description = "收货地址")
    private String address;

        /**
     * 收货人
     */
    @Schema(description = "收货人")
    private String consignee;

        /**
     * 收货人电话
     */
    @Schema(description = "收货人电话")
    private String consigneePhone;

        /**
     * 支付状态
     */
    @Schema(description = "支付状态")
    private Byte payState;

    }
