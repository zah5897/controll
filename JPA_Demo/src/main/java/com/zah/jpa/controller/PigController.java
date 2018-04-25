package com.zah.jpa.controller;

import com.zah.jpa.dao.PigDao;
import com.zah.jpa.dao.UserDao;
import com.zah.jpa.entity.Genes;
import com.zah.jpa.entity.Pig;
import com.zah.jpa.entity.User;
import com.zah.jpa.util.GenesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pig")
public class PigController {

    @Autowired
    private PigDao pigDao;

    @RequestMapping(value = "/load/{owner}", method = RequestMethod.GET)
    public List<Pig> load(@PathVariable("owner") String owner) {
        return this.pigDao.getOwnPig(owner);
    }

    @RequestMapping(value = "/create/{owner}", method = RequestMethod.GET)
    public Genes create(@PathVariable("owner") String owner) {
        return GenesUtil.createGenes(0);
    }
}