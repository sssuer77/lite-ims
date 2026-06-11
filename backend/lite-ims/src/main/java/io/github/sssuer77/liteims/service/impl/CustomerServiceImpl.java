package io.github.sssuer77.liteims.service.impl;

import io.github.sssuer77.liteims.entity.Customer;
import io.github.sssuer77.liteims.mapper.CustomerMapper;
import io.github.sssuer77.liteims.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}
