package com.hs.mapper;

import com.hs.entity.Xc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XcMapper {

    int addXc(Xc xc);

    int updateXc(Xc xc);

    int deleteXc(String xc_id);

//    List<Xc> selectAllXc(String username);

    List<Xc> selectAllXc();

    Xc selectXcByXcid(int xc_id);

    Xc selectXcByXcname(String xc_name);

}
