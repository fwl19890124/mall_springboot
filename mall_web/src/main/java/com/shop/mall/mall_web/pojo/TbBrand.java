package com.shop.mall.mall_web.pojo;

import javax.persistence.*;

/**
 * 
 * 商品品牌表
 * @author wcyong
 * 
 * @date 2018-11-13
 */
@Table(name = "tb_brand")
public class TbBrand {

    @Column(name = "id")
    private Long id;

    /**
     * 品牌名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 品牌首字母
     */
    @Column(name = "first_char")
    private String firstChar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}