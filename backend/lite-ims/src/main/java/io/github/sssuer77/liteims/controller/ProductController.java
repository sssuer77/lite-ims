package io.github.sssuer77.liteims.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.sssuer77.liteims.common.Result;
import io.github.sssuer77.liteims.entity.Product;
import io.github.sssuer77.liteims.service.ProductService;
import io.github.sssuer77.liteims.vo.ProductVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "商品管理")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "分页查询商品")
    public Result<IPage<ProductVO>> list(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "10") Integer size,
                                         String name, Long categoryId) {
        Page<ProductVO> pageParam = new Page<>(page, size);
        // 调用 Service 层方法
        IPage<ProductVO> result = productService.getProductList(pageParam, name, categoryId);
        return Result.success(result);
    }

    @PostMapping
    @Operation(summary = "添加商品")
    public Result<Object> add(@RequestBody Product product) {
        return productService.save(product) ? Result.success(null) : Result.fail("添加失败");
    }

    @PutMapping
    @Operation(summary = "更新商品")
    public Result<Object> update(@RequestBody Product product) {
        return productService.updateById(product) ? Result.success(null) : Result.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除商品")
    public Result<Object> delete(@PathVariable Long id) {
        return productService.removeById(id) ? Result.success(null) : Result.fail("删除失败");
    }
}