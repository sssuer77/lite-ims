package io.github.sssuer77.liteims.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.sssuer77.liteims.common.Result;
import io.github.sssuer77.liteims.dto.OrderDTO;
import io.github.sssuer77.liteims.service.SaleOrderService;
import io.github.sssuer77.liteims.vo.SaleOrderVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "订单管理")
public class SaleOrderController {
    @Autowired
    private SaleOrderService saleOrderService;

    @GetMapping
    @Operation(summary = "获取订单列表")
    public Result<IPage<SaleOrderVO>> list(Integer page, Integer size, String orderNo) {
        return Result.success(saleOrderService.getOrderList(page, size, orderNo));
    }

    @PostMapping
    @Operation(summary = "创建订单")
    public Result<Object> createOrder(@RequestBody OrderDTO orderDTO) {
        saleOrderService.createOrder(orderDTO);
        return Result.success("订单创建成功", null);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "更新订单状态")
    public Result<Object> updateStatus(@PathVariable Long id, @RequestParam Integer status) {
        saleOrderService.updateStatus(id, status);
        return Result.success(null);
    }
}