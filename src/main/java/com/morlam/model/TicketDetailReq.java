package com.morlam.model;

import lombok.Data;

@Data
public class TicketDetailReq {
    private Integer ticketId;
    private String ticketName;
    private Integer ticketType;
    private Integer ticketPrice;
    private String ticketDesc;
}
