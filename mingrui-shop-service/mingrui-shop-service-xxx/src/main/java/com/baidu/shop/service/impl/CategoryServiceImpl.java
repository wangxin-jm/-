package com.baidu.shop.service.impl;

import com.baidu.shop.base.BaseApiService;
import com.baidu.shop.base.Result;
import com.baidu.shop.entity.CategoryEntity;
import com.baidu.shop.mapper.CategoryMapper;
import com.baidu.shop.service.CategoryService;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2 * @ClassName CategoryServiceImpl
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/1/20
 * 6 * @Version V1.0
 * 7
 **/
@RestController
public class CategoryServiceImpl extends BaseApiService implements CategoryService {
    @Resource
    private CategoryMapper mapper;

    @Override
    public Result<List<CategoryEntity>> getCategoryByPid(Integer pid) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setParentId(pid);
        List<CategoryEntity> list = mapper.select(categoryEntity);
        return this.setResultSuccess(list);
    }

    @Override
    public Result<JsonObject> deleteById(Integer id) {

        if (id == null || id <= 0) {
            return this.setResultError("id不合法");
        }
        //得到查询的那一条数据
        CategoryEntity categoryEntity = mapper.selectByPrimaryKey(id);

        //在判断数据存不存在
        if (categoryEntity == null) {
            return this.setResultError("数据不存在");
        }

        //如果这条数据存在,判断这条数据是不是父节点 isparent = 1是父节点
        if (categoryEntity.getIsParent() == 1) {
            return this.setResultError("当前节点为父节点不能被删除");
        }

        //如果不是父节点在查询parentId有几条数据
        Example example = new Example(CategoryEntity.class);
        example.createCriteria().andEqualTo("parentId",categoryEntity.getParentId());
        List<CategoryEntity> categoryEntities = mapper.selectByExample(example);


        if (categoryEntities.size() <= 1 ) {
            CategoryEntity categoryEntity1 = new CategoryEntity();
            categoryEntity1.setIsParent(0);
            categoryEntity1.setId(categoryEntity.getParentId());
            mapper.updateByPrimaryKeySelective(categoryEntity1);

        }


        mapper.deleteByPrimaryKey(id);
        return this.setResultSuccess("操作成功");
    }

    @Override
    public Result<JsonObject> save(CategoryEntity categoryEntity) {
        Integer parentId = categoryEntity.getParentId();

        CategoryEntity categoryEntity1 = mapper.selectByPrimaryKey(parentId);

        if(categoryEntity1 == null ){
            return this.setResultError("操作失败");
        }

        if(categoryEntity1.getIsParent() == 0){
            CategoryEntity categoryEntity2 = new CategoryEntity();
            categoryEntity2.setIsParent(1);
            categoryEntity2.setId(parentId);
            mapper.updateByPrimaryKeySelective(categoryEntity2);
        }

        mapper.insertSelective(categoryEntity);
        return this.setResultSuccess("新增成功");
    }

    @Override
    public Result<JsonObject> update(CategoryEntity categoryEntity) {
        mapper.updateByPrimaryKeySelective(categoryEntity);
        return this.setResultSuccess("修改成功");
    }

}
