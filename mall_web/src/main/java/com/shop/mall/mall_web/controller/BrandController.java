package com.shop.mall.mall_web.controller;

import com.shop.mall.mall_web.pojo.TbBrand;
import com.shop.mall.mall_web.pojo.entity.PageResult;
import com.shop.mall.mall_web.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        List<TbBrand> brand = brandService.findAll();
        return brand;
    }

    /**
     * @param page
     * @param size
     * @return
     * 分页查询
     */
    @RequestMapping("/findPage")
    public PageResult<TbBrand> findPage(Integer page,Integer size,@RequestBody TbBrand brand){
        System.out.println("page="+page+", size="+size+", firstChar="+brand.getFirstChar()+", name="+brand.getName());
        PageResult<TbBrand> result = brandService.findPage(page, size,brand);
        System.out.println("获取到的结果："+result);
        return result;
    }

    /**
     * @return
     * 插入品牌信息
     */
    @RequestMapping("/add")
    public Map insertBrandInfo( @RequestBody TbBrand brand){
        //new 一个tbBrand
        Map<String, Object> map = new HashMap<>();
        //将数据插入数据库并返回是否插入成功(true/false)
        Boolean flag = brandService.insertBrand(brand);
        //判断品牌保存是否成功并返回相应的信息给前端
        if (flag == true) {
            map.put("code", "1");
            map.put("message", "品牌保存成功");
        } else {
            map.put("code", "0");
            map.put("message", "品牌保存失败");
        }
        return map;
    }

    /**
     * @param tbBrand
     * @return
     * 更新品牌信息
     */
    @RequestMapping("/updateBrand")
    public Map updateBrand(@RequestBody TbBrand tbBrand){
        Map map = new HashMap();
        Boolean flag = brandService.updateBrand(tbBrand);
        System.out.println("更新返回的值："+flag);
        if (flag == true) {
            map.put("code", "1");
            map.put("message", "更新成功");
        } else {
            map.put("code", "0");
            map.put("message", "更新失败");
        }
        return map;
    }

    /**
     * @param id
     * @return
     * 根据id查询品牌信息
     */
    @RequestMapping("/findById")
    public TbBrand findById( Long id){
        TbBrand brand = brandService.findById(id);
        return brand;
    }

    /**
     * @param ids
     * @return
     * 根据id删除品牌信息
     */
    @RequestMapping("/deleteBrand")
    public Map deleteBrand(Long[] ids) {
        Map map = new HashMap();
        System.out.println("前端传过来的ids："+ids);
        Boolean flag = brandService.deleteBrand(ids);
        if (flag == true) {
            map.put("message", "删除成功");
        } else {
            map.put("message", "删除失败");
        }
        return map;
    }
}
