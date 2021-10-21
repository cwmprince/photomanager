package com.hs.service;

import com.hs.entity.Photo;
import com.hs.entity.Photo1;

import java.util.List;

public interface PhotoService {

    int insertPhoto(Photo1 photo1);


    Photo findPhotoByPid(int p_id);

    int deletePhoto(int p_id);

    List<Photo> findAllPhoto(String username);

    int updatePhoto(int p_id,int xc_id);

    List<Photo> findPhotoByXc_id(int xc_id);

    List<Photo> findPhotoByCid(int c_id);
}
