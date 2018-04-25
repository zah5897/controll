package com.zhan.app.controll.controller;

import com.zhan.app.controll.entity.Device;
import com.zhan.app.controll.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zah on 2018/4/24.
 */
@RestController
@RequestMapping("/device")
@Api(value = "设备", tags = {"设备操作接口"})
public class DeviceController {


    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value = "添加设备", notes = "用户添加设备")
    @PostMapping("/add")
    public Device add(@ApiParam(name = "device", value = "设备对象") Device device) {
        return deviceService.add(device);
    }

    @ApiOperation(value = "获取设备", notes = "根据id获取设备")
    @GetMapping("/{id}")
    public Device get(@ApiParam(name = "id", value = "设备ID") @PathVariable int id) {
        return deviceService.get(id);
    }
}
