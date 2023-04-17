package com.morlam.model;

import lombok.Data;

@Data
public class UserResponeModel {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String phone;
    private String avatar;
    private Integer status;
}
