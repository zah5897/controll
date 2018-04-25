package com.zhan.app.controll.service;

import com.zhan.app.controll.entity.Device;
import com.zhan.app.controll.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zah on 2018/4/25.
 */
@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> list() {
        return deviceRepository.listAll();
    }

    public Device add(Device device) {
        device.setCreate_time(new Date());
        deviceRepository.save(device);
        return device;
    }

    public Device get(int id) {
        return (Device) deviceRepository.getOne(id);
    }
}
