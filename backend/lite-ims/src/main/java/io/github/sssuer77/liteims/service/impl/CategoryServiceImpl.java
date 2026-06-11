package io.github.sssuer77.liteims.service.impl;

import io.github.sssuer77.liteims.entity.Category;
import io.github.sssuer77.liteims.mapper.CategoryMapper;
import io.github.sssuer77.liteims.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
