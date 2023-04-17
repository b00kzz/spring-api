package com.morlam.model;

import lombok.Data;

@Data
public class TicketDetailResp {
    private Integer ticketId;
    private String ticketName;
    private Integer ticketType;
    private Integer ticketPrice;
    private String ticketDesc;
}
