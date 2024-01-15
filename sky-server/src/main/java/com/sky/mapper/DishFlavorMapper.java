package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    // 批量插入口味数据
    void insertBatch (List<DishFlavor> flavors);

    // 删除菜品时顺带删除其口味
    @Delete("delete from dish_flavor where dish_id=#{dishId}")
    void deleteByDishId (Long dishId);

    // 根据菜品id集合批量删除关联的口味数据
    void deleteByDishIds (List<Long> dishIds);

    // 根据菜品id查询对应口味数据
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId (Long dishId);
}
