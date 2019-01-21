package com.shop.mall.mall_web.service.impl;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mall.mall_web.mapper.TbBrandMapper;
import com.shop.mall.mall_web.pojo.TbBrand;
import com.shop.mall.mall_web.pojo.entity.PageResult;
import com.shop.mall.mall_web.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        List<TbBrand> list = tbBrandMapper.findAll();
        return list;
    }

    @Override
    public PageResult<TbBrand> findPage(Integer page, Integer size,TbBrand brand) {
        Map map = new HashMap();
        PageResult<TbBrand> result = new PageResult<>();
        //设置分页条件
        PageHelper.startPage(page,size);
        //查询数据
        List<TbBrand> brands = tbBrandMapper.findAll();
        if (brand.getName() != null || brand.getFirstChar() != null) {
            brands = tbBrandMapper.findBrand(brand);
        }
        //保存数据列
        result.setRows(brands);
        //获取总记录数
        PageInfo<TbBrand> info = new PageInfo<>(brands);
        result.setTotal(info.getTotal());
        return result;
    }

    @Override
    public Boolean insertBrand(TbBrand tbBrand) {
        Integer num = tbBrandMapper.insertBrand(tbBrand);
        Boolean flag = false;
        if (num > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * @param tbBrand
     * @return
     * 更新品牌信息
     */
    @Override
    public Boolean updateBrand(TbBrand tbBrand) {
        Integer num = tbBrandMapper.updateBrand(tbBrand);
        Boolean flag = false;
        if (num > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public TbBrand findById(Long id) {
        TbBrand tbBrand = tbBrandMapper.selectById(id);
        return tbBrand;
    }

    @Override
    public Boolean deleteBrand(Long[] ids) {
        System.out.println("ids="+ids);
        List<Object> longs = Arrays.asList(ids);
        System.out.println("longs="+longs);
//        Integer num = 0;
//        for (Object id:longs) {
//            System.out.println("id="+id);
//            num=tbBrandMapper.deleteBrand(Long.parseLong(id.toString()));
//            System.out.println("删除数据num的值："+num);
//        }
        Integer num=0;
        for (Long id : ids) {
            System.out.println("id="+id);
             num = tbBrandMapper.deleteBrand(id);
            System.out.println("删除数据num的值："+num);
        }
//        Example example = new Example(TbBrand.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andIn("id", longs);
//        System.out.println("example中的值是什么："+example);
//        Integer num = tbBrandMapper.deleteBrand(example);
            System.out.println("num=" + num);
        Boolean flag = false;
        if (num > 0) {
            flag = true;
        }
        return flag;
    }


}
