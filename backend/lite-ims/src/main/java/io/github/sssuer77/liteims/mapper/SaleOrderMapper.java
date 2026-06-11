package io.github.sssuer77.liteims.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.sssuer77.liteims.entity.SaleOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import io.github.sssuer77.liteims.vo.SaleOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaleOrderMapper extends BaseMapper<SaleOrder> {

    /**
     * 获取订单总额度
     *
     * @return
     */
    /**
     * 分页查询订单列表
     */
    IPage<SaleOrderVO> selectOrderList(Page<SaleOrderVO> page,
                                       @Param("orderNo") String orderNo);

    @Select("SELECT IFNULL(SUM(total_amount), 0) FROM sale_order WHERE is_deleted = 0 AND status != 2")
    BigDecimal getTotalSales();

}