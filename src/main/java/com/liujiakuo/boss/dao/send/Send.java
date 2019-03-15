package com.liujiakuo.boss.dao.send;

import javax.persistence.*;
import java.util.Date;

/**
 * 投递表
 */
@Entity
@Table(name = "send")
public class Send {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private Long ID;

    /**
     * 投递者
     */
    @Column(name = "poster_id")
    private Long PID;

    /**
     * 职位id
     */
    @Column(name = "position_id")
    private Long PosID;

    /**
     * 投递时间
     */
    @Column(name = "time")
    private Date time;
}
