package io.github.sssuer77.liteims.controller;

import io.github.sssuer77.liteims.common.Result;
import io.github.sssuer77.liteims.service.DashboardService;
import io.github.sssuer77.liteims.vo.DashboardVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@Tag(name = "仪表盘")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    @Operation(summary = "获取统计数据")
    public Result<DashboardVO> getStats() {
        // 调用 Service 层方法
        return Result.success(dashboardService.getStats());
    }
}