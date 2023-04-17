package com.morlam.model;


import java.util.Date;

import lombok.Data;
@Data

public class TicketBuyResModel {
    private Integer buyId;
    private Integer buyStatus;
    private Date buyDate;
}
