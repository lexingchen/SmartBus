package com.example.test.serviceImpl;

import com.example.test.bean.S_data;
import com.example.test.mapper.DataMapper;
import com.example.test.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("DataServices")
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public int s_datdadd(S_data s_data) {
        return dataMapper.s_dataadd(s_data);
    }
    @Override
    public List<S_data> datalist() {
        return dataMapper.datalist();
    }

    @Override
    public S_data datashow() {
        return dataMapper.datashow();
    }

    @Override
    public List<S_data> datalist3() {
        return dataMapper.datalist3();
    }


}
