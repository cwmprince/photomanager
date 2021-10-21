package com.hs.service;

import com.hs.entity.Xc;

import java.util.List;

public interface XcService {

    int register(Xc xc);

    int update(Xc xc);

    int delete(String xc_id);

//    List<Xc> selectAllXc(String username);

    Xc selectXcByXcid(int xc_id);

    Xc selectXcByXcname(String xc_name);

    List<Xc> selectAllXc();
}
