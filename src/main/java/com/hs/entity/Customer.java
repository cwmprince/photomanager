package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    private int c_id;
    private String username;
    private String passwd;
    private String c_name;
    private String c_sex;
    private String c_tel;
}
