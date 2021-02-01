package com.baidu.shop.service;

import com.baidu.shop.base.Result;
import com.baidu.shop.dto.SpuDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 2 * @ClassName GoodsService
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/2/1
 * 6 * @Version V1.0
 * 7
 **/
@Api(tags = "商品接口")
public interface GoodsService {
    @ApiOperation(value = "获取spu信息")
    @GetMapping(value = "goods/getSpuInfo")
    public Result<List<SpuDTO>> getSpuInfo(SpuDTO spuDTO);
}
