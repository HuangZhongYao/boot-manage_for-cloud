package org.github.bm.example.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.github.bm.common.base.vo.BaseIdAndTimeAndOperationIdVO;

import java.io.Serial;
import java.time.LocalDateTime;


/**
 * 车辆表VO对象
 * @Desc Created by Velocity Generate.
 * @Time 2024-07-31 20:23:37
 * @Author zuuuYao (https://github.com/HuangZhongYao)
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BusTruckVO extends BaseIdAndTimeAndOperationIdVO {

    @Serial
    private static final long serialVersionUID = -1;

        /**
     * 品牌
     */
    @Schema(description = "品牌")
    private String brand;

        /**
     * 发动机编号
     */
    @Schema(description = "发动机编号")
    private String engineNo;

        /**
     * 文档编号
     */
    @Schema(description = "文档编号")
    private String fileNo;

        /**
     * 发证机关
     */
    @Schema(description = "发证机关")
    private String issuers;

        /**
     * 型号
     */
    @Schema(description = "型号")
    private String model;

        /**
     * 车辆所有人
     */
    @Schema(description = "车辆所有人")
    private String owner;

        /**
     * 车牌号
     */
    @Schema(description = "车牌号")
    private String plateNo;

        /**
     * 总质量kg
     */
    @Schema(description = "总质量kg")
    private Integer quality;

        /**
     * 注册日期
     */
    @Schema(description = "注册日期")
    private LocalDateTime regDate;

        /**
     * 使用性质
     */
    @Schema(description = "使用性质")
    private String useCharacter;

        /**
     * 车型
     */
    @Schema(description = "车型")
    private String vehicleType;

        /**
     * VIN车辆识别代码
     */
    @Schema(description = "VIN车辆识别代码")
    private String vin;

    }

