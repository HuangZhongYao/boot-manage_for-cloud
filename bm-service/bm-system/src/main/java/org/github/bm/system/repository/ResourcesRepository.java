package org.github.bm.system.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.github.bm.base.mybatis.BaseMapperExtension;
import org.github.bm.base.util.tree.ITreeNode;
import org.github.bm.system.entity.ResourcesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Desc: Created by IntelliJ IDEA.
 * @Author: ZhongYao.Huang
 * @Copyright: ZuuuuYao By Github
 * @Time: 2024-07-13 18:39
 */
@Repository
public interface ResourcesRepository extends BaseMapperExtension<ResourcesEntity> {
    List<ITreeNode<Long>> selectList(QueryWrapper<Object> objectQueryWrapper, Class<ITreeNode> iTreeNodeClass);
}
