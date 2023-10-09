package com.example.test.service;

import com.example.test.bean.S_data;

import java.util.List;

public interface DataService {
    int s_datdadd(S_data s_data);
    List<S_data>datalist();
    S_data datashow ();
    List<S_data>datalist3();
}
