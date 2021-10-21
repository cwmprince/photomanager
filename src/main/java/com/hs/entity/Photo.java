package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Photo {

    private int p_id;
    private String o_name;
    private String u_name;
    private String u_date;
    private Customer customer;
    private Xc xc;
}
