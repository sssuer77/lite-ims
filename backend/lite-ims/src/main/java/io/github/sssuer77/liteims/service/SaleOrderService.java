package io.github.sssuer77.liteims.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.sssuer77.liteims.dto.OrderDTO;
import io.github.sssuer77.liteims.entity.SaleOrder;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.sssuer77.liteims.vo.SaleOrderVO;

public interface SaleOrderService extends IService<SaleOrder> {

    IPage<SaleOrderVO> getOrderList(Integer page, Integer size, String orderNo);
    void createOrder(OrderDTO orderDTO);

    void updateStatus(Long id, Integer status);
}
