package io.github.sssuer77.liteims.controller;

import io.github.sssuer77.liteims.common.Result;
import io.github.sssuer77.liteims.entity.Category;
import io.github.sssuer77.liteims.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "分类管理")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "获取所有分类")
    public Result<List<Category>> list() {
        // 自动追加 WHERE is_deleted = 0
        return Result.success(categoryService.list());
    }

    @PostMapping
    @Operation(summary = "添加分类")
    public Result<Object> add(@RequestBody Category category) {
        return categoryService.save(category) ? Result.success(null) : Result.fail("添加失败");
    }

    @PutMapping
    @Operation(summary = "更新分类")
    public Result<Object> update(@RequestBody Category category) {
        return categoryService.updateById(category) ? Result.success(null) : Result.fail("更新失败");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除分类")
    public Result<Object> delete(@PathVariable Long id) {
        // 自动执行 UPDATE category SET is_deleted=1 WHERE id=? AND is_deleted=0
        return categoryService.removeById(id) ? Result.success(null) : Result.fail("删除失败");
    }
}