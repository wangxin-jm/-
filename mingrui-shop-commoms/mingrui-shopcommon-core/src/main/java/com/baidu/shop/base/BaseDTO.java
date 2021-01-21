package com.baidu.shop.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 2 * @ClassName BaseDTO
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/1/21
 * 6 * @Version V1.0
 * 7
 **/
@Data
@ApiModel(value = "BaseDTO用于数据传输,其他dto需要继承此类")
public class BaseDTO {
    @ApiModelProperty(value = "当前页", example = "1")
    private Integer page;
    @ApiModelProperty(value = "每页显示多少条",example = "5")
    private Integer rows;
    @ApiModelProperty(value = "排序字段")
    private String sort;
    @ApiModelProperty(value = "是否升序")
    private String order;

    @ApiModelProperty(hidden = true)
    public String getOrderByClause(){
        return sort+" "+(Boolean.valueOf(order)?"desc":"asc");
    }
}
