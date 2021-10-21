package com.hs.mapper;

import com.hs.entity.Photo;
import com.hs.entity.Photo1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoMapper {

    int insertPhoto(Photo1 photo1);

    List<Photo> selectAllPhoto(int c_id);

    Photo selectPhotoByPid(int p_id);

    int deletePhoto(int p_id);

    int updatePhoto(int p_id,int xc_id);

    List<Photo> selectPhotoByXc_id(int xc_id);

    List<Photo> selectPhotoByCid(int c_id);

}
