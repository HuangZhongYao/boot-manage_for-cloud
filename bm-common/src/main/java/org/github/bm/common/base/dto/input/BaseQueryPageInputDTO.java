package org.github.bm.common.base.dto.input;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.bm.common.base.dto.BaseDTO;

import java.io.Serial;

/**
 * @Desc 分页查询DTO基类
 * @Time 2024-07-11 14:49
 * @Author HuangZhongYao
 * @param <Entity> 实体类型
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseQueryPageInputDTO<Entity> extends BaseDTO {

    @Serial
    private static final long serialVersionUID = -2789045699043909727L;

    /**
     * 最小查询条数
     */
    private static final long MIN_SIZE = 10L;

    /**
     * 最小查询页数
     */
    private static final long MIN_PAGE_NO = 1L;

    /**
     * 关键字查询
     */
    @Schema(name = "keyword", description = "关键字查询", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String keyword;

    @Schema(name = "pageSize", description = "每页显示条数", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private long pageSize = MIN_SIZE;

    @Schema(name = "pageNo", description = "当前页码", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private long pageNo = MIN_PAGE_NO;

    public BaseQueryPageInputDTO() {
    }

    public BaseQueryPageInputDTO(long current, long pageSize) {
        if (current > MIN_PAGE_NO) {
            this.pageNo = current;
        }

        if (pageSize > MIN_SIZE) {
            this.pageSize = pageSize;
        }

    }

    /**
     * 转换为mybatis-plus分页查询对象
     *
     * @return Page mybatis分页查询对象
     */
    public Page<Entity> toMybatisPageObject() {
        return new Page<Entity>(this.pageNo, this.pageSize);
    }

}
