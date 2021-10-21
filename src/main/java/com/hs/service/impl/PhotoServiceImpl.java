package com.hs.service.impl;

import com.hs.entity.Customer;
import com.hs.entity.Photo;
import com.hs.entity.Photo1;
import com.hs.mapper.CustomerMapper;
import com.hs.mapper.PhotoMapper;
import com.hs.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int insertPhoto(Photo1 photo1) {
        int i = photoMapper.insertPhoto(photo1);
        return i;
    }

    @Override
    public Photo findPhotoByPid(int p_id) {
        Photo photo = photoMapper.selectPhotoByPid(p_id);
        return photo;
    }

    @Override
    public int deletePhoto(int p_id) {
        int i = photoMapper.deletePhoto(p_id);
        return i;
    }

    @Override
    public List<Photo> findAllPhoto(String username) {
        Customer customer = customerMapper.selectCustomerByUsername(username);
        List<Photo> photos = photoMapper.selectAllPhoto(customer.getC_id());
        return photos;
    }

    @Override
    public int updatePhoto(int p_id,int xc_id) {
        int i = photoMapper.updatePhoto(p_id,xc_id);
        return i;
    }

    @Override
    public List<Photo> findPhotoByXc_id(int xc_id) {
        List<Photo> photos = photoMapper.selectPhotoByXc_id(xc_id);
        return photos;
    }

    @Override
    public List<Photo> findPhotoByCid(int c_id) {
        List<Photo> photos = photoMapper.selectPhotoByCid(c_id);
        return photos;
    }

}
