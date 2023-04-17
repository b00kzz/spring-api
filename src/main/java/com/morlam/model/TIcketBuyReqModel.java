package com.morlam.model;


import java.util.Date;

import lombok.Data;

@Data
public class TIcketBuyReqModel {
    private Integer buyId;
    private Integer buyStatus;
    private Date buyDate;
}
