package com.study.shinhan_webapp_study.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter@Setter@ToString
public class BoardDto {
    public enum StatusType {
        PUBLIC, PRIVATE, REPORT, BLOCK
    }
    private int bId;//b_id; pk generate key(auto increment)
    private String uId;//u_id; fk Users.u_id
    private Date postTime;//post_time;
    private Date updateTime;//update_time;
    private StatusType status;
    private String title;
    private String content;
    private int viewCount;//view_count;
}
