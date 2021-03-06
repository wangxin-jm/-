package com.baidu.shop.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 2 * @ClassName JSONUtil
 * 3 * @Description: TODO
 * 4 * @Author wangxin
 * 5 * @Date 2021/1/20
 * 6 * @Version V1.0
 * 7
 **/
@Data
@Table(name="tb_category_brand")
@ApiModel(value="品牌分类关系表")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBrandEntity {
    //品牌中间表实体类

    private Integer categoryId;

    private Integer brandId;


}
