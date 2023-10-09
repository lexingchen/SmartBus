package com.example.test.mapper;

import com.example.test.bean.S_data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMapper {
    int s_dataadd(S_data s_data);
    List<S_data> datalist();
    S_data datashow ();
    List<S_data> datalist3();
}
