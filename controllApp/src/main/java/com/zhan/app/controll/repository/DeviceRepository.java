package com.zhan.app.controll.repository;

import com.zhan.app.controll.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zah on 2018/4/25.
 */
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query("select d from Device d")
    List<Device> listAll();
}
