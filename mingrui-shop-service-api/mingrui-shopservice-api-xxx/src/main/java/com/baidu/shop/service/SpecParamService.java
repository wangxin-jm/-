package com.baidu.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.baidu.shop.base.Result;
import com.baidu.shop.dto.SpecParamDTO;
import com.baidu.shop.entity.SpecParamEntity;
import com.baidu.shop.validate.group.MingruiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 2 * @ClassName SpecParamService
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/1/27
 * 6 * @Version V1.0
 * 7
 **/
@Api(tags = "规格参数接口")
public interface SpecParamService {
//查询
    @ApiOperation("规格参数查询")
    @GetMapping("specParam/list")
    Result<SpecParamEntity> list(SpecParamDTO specParamDTO);
//规格参数新增
    @ApiOperation("规格参数新增")
    @PostMapping("specParam/save")
    Result<JSONObject> save(@Validated({MingruiOperation.Add.class})@RequestBody SpecParamDTO specParamDTO);
//修改
    @ApiOperation("规格参数修改")
    @PutMapping("specParam/save")
    Result<JSONObject> update(@Validated({MingruiOperation.Update.class})@RequestBody SpecParamDTO specParamDTO);
//删除规格参数
    @ApiOperation("删除规格参数")
    @DeleteMapping("specParam/delete")
    Result<JSONObject> delete(Integer id);


}
