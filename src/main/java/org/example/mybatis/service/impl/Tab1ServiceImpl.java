package org.example.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.mybatis.entry.Tab1;
import org.example.mybatis.mapper.Tab1Mapper;
import org.example.mybatis.service.Tab1Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author poju
* @description 针对表【tab1】的数据库操作Service实现
* @createDate 2025-07-29 20:15:21
*/
@Service
public class Tab1ServiceImpl extends ServiceImpl<Tab1Mapper, Tab1>
    implements Tab1Service{

    @Resource
    private Tab1Mapper tab1Mapper;

    public List<Tab1> getAllTab1s() {
        QueryWrapper<Tab1> wrapper = new QueryWrapper<>();
        wrapper.eq("age",12);
        List tabls = tab1Mapper.selectList(wrapper);
        return tabls;
    }
}




