package com.shop.mall.mall_web.service;

import com.shop.mall.mall_web.pojo.TbBrand;
import com.shop.mall.mall_web.pojo.entity.PageResult;

import java.util.List;

public interface BrandService {
    /**
     * 获取品牌表中的所有数据
     */
    List<TbBrand> findAll();

    /**
     * @param page
     * @param size
     * @return
     * 分页查询品牌列表
     */
    PageResult<TbBrand> findPage(Integer page,Integer size,TbBrand brand);

    /**
     * @param tbBrand
     * @return
     * 插入品牌信息
     */
    Boolean insertBrand(TbBrand tbBrand);

    /**
     * @param tbBrand
     * @return
     * 更新品牌信息
     */
    Boolean updateBrand(TbBrand tbBrand);

    /**
     * @param id
     * @return
     * 根据id查询品牌信息
     */
    TbBrand findById(Long id);

    /**
     * @param ids
     * @return
     * 根据id删除品牌信息
     */
    Boolean deleteBrand(Long[] ids);
}
