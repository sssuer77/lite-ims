package io.github.sssuer77.liteims.mapper;

import io.github.sssuer77.liteims.entity.Product;
import io.github.sssuer77.liteims.vo.ProductVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 分页查询商品列表（包含分类名称）
     * @param page 分页参数
     * @param name 商品名称 (可选)
     * @param categoryId 分类ID (可选)
     * @return 分页结果
     */
    IPage<ProductVO> selectProductList(Page<ProductVO> page,
                                       @Param("name") String name,
                                       @Param("categoryId") Long categoryId);


}
