package org.github.bm.common.base.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import org.github.bm.common.base.dto.BaseDTO;
import org.github.bm.common.validate.ValidateNotNullAndEmpty;

import java.io.Serial;
import java.util.ArrayList;

/**
 * 多个Long类型 id集合 DTO基类
 * @Desc
 * @Time 2024-07-12 10:31
 * @Author HuangZhongYao
 */
public class BaseManyLongIdInputDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 7165155487737319430L;

    public BaseManyLongIdInputDTO() {
    }

    public BaseManyLongIdInputDTO(ArrayList<Long> ids) {
        this.ids = ids;
    }

    /**
     * ids
     */
    @ValidateNotNullAndEmpty(message = "id集合不能为空")
    @Schema(name = "ids",requiredMode = Schema.RequiredMode.REQUIRED,example = "[1092327965422,12398293009,1092323556]")
    private ArrayList<Long> ids = new ArrayList<>();

    public ArrayList<Long> getIds() {
        return ids;
    }

    public void setIds(ArrayList<Long> ids) {
        this.ids = ids;
    }
}
