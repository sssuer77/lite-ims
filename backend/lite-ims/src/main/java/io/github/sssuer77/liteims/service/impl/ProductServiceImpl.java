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
    ProductMapper productMapper;

    @Override
    public IPage<ProductVO> findPage(Integer page, Integer size, String name, Long categoryId) {
        return productMapper.findPage(new Page<>(page, size),name,categoryId);
    }
}
