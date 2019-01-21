package com.shop.mall.mall_web.mapper;

import com.github.abel533.entity.Example;
import com.shop.mall.mall_web.pojo.TbBrand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TbBrandMapper  {

    /**
     * @return
     * 查询所有品牌信息
     */
    @Select("SELECT id,name,first_char as firstChar FROM tb_brand")
    List<TbBrand> findAll();

//    @Select("SELECT id,name,first_char as firstChar FROM tb_brand limit (#{page} - 1),#{size}")
//    List<TbBrand> findPage(Integer page, Integer size);



    /**
     * @param tbBrand
     * @return
     * 插入品牌信息
     */
    @Insert("INSERT INTO `mydb`.`tb_brand` ( `name`, `first_char`) \n" +
            "VALUES\n" +
            "  (#{name},#{firstChar})")
    Integer insertBrand(TbBrand tbBrand);

    @Update("UPDATE \n" +
            "  `mydb`.`tb_brand` \n" +
            "SET\n" +
            "  `name` = #{name},\n" +
            "  `first_char` = #{firstChar} \n" +
            "WHERE `id` = #{id} ;\n")
    Integer updateBrand(TbBrand tbBrand);

    @Select("SELECT id,name,first_char as firstChar FROM tb_brand WHERE id = #{id}")
    TbBrand selectById(Long id);

    @Delete("DELETE \n" +
            "FROM\n" +
            "  `mydb`.`tb_brand` \n" +
            "WHERE `id` = #{id} ;")
    Integer deleteBrand(Long id);

    /**
     * @return
     * 查询相应品牌信息
     */
    @Select("SELECT id,name,first_char as firstChar FROM tb_brand WHERE name LIKE CONCAT(CONCAT('%',#{name}),'%') OR first_char LIKE #{firstChar};")
    List<TbBrand> findBrand(TbBrand brand);
}
