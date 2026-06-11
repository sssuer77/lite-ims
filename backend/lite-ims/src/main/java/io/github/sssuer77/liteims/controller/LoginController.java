package io.github.sssuer77.liteims.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.sssuer77.liteims.common.Result;
import io.github.sssuer77.liteims.entity.SysUser;
import io.github.sssuer77.liteims.mapper.SysUserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "登录模块") // Knife4j: 模块名称
public class LoginController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @PostMapping("/login")
    @Operation(summary = "用户登录") // Knife4j: 接口描述
    public Result<SysUser> login(@RequestBody SysUser loginUser, HttpSession session) {
        // 1. 构建查询条件：WHERE username = ?
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUser::getUsername, loginUser.getUsername());

        // 2. 查询数据库
        SysUser user = sysUserMapper.selectOne(queryWrapper);

        // 3. 校验密码
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            // 登录成功，将用户信息存入 Session
            session.setAttribute("user", user);
            return Result.success("登录成功", user);
        }
        return Result.fail(401, "登录失败：用户名或密码错误");
    }

    @GetMapping("/logout")
    @Operation(summary = "用户登出")
    public Result<Object> logout(HttpSession session) {
        session.invalidate(); // 销毁 Session
        return Result.success("退出成功", null);
    }
}