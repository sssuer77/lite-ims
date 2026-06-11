package io.github.sssuer77.liteims.service.impl;

import io.github.sssuer77.liteims.entity.Product;
import io.github.sssuer77.liteims.mapper.ProductMapper;
import io.github.sssuer77.liteims.service.ProductService;
import io.github.sssuer77.liteims.vo.ProductVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<ProductVO> getProductList(Page<ProductVO> page, String name, Long categoryId) {
        // 直接调用 Mapper 自定义方法
        return productMapper.selectProductList(page, name, categoryId);
    }
}