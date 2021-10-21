package com.hs.service.impl;

import com.hs.entity.Xc;
import com.hs.mapper.XcMapper;
import com.hs.service.XcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XcServiceImpl implements XcService {

    @Autowired
    private XcMapper xcMapper;

    @Override
    public int register(Xc xc) {
        int i = xcMapper.addXc(xc);
        return i;
    }

    @Override
    public int update(Xc xc) {
        int i = xcMapper.updateXc(xc);
        return i;
    }

    @Override
    public int delete(String xc_id) {
        int i = xcMapper.deleteXc(xc_id);
        return i;
    }

//    @Override
//    public List<Xc> selectAllXc(String username) {
//        List<Xc> xcs = xcMapper.selectAllXc(username);
//        return xcs;
//    }

    @Override
    public Xc selectXcByXcid(int xc_id) {
        Xc xc = xcMapper.selectXcByXcid(xc_id);
        return xc;
    }

    @Override
    public Xc selectXcByXcname(String xc_name) {
        Xc xc = xcMapper.selectXcByXcname(xc_name);
        return xc;
    }

    @Override
    public List<Xc> selectAllXc() {
        List<Xc> xcs = xcMapper.selectAllXc();
        return xcs;
    }
}
