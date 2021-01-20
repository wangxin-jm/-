package com.baidu.shop.service;

import com.baidu.shop.base.Result;
import com.baidu.shop.entity.CategoryEntity;
import com.google.gson.JsonObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 2 * @ClassName CategoryService
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/1/20
 * 6 * @Version V1.0
 * 7
 **/

public interface CategoryService {

    @ApiOperation(value = "通过查询商品分类")
    @GetMapping(value = "category/list")
    Result<List<CategoryEntity>> getCategoryByPid(Integer pid);

    @ApiOperation(value="删除不是父节点的")
    @DeleteMapping(value="category/delete")
    Result<JsonObject> deleteById(Integer id);

    @ApiOperation(value="新增节点")
    @PostMapping(value="category/save")
    Result<JsonObject> save(@RequestBody CategoryEntity categoryEntity);

    @ApiOperation(value="修改节点")
    @PutMapping(value="category/upfate")
    Result<JsonObject> update(@RequestBody CategoryEntity categoryEntity);

}
