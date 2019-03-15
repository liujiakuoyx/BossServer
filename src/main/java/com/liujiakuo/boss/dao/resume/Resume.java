package com.liujiakuo.boss.dao.resume;

import javax.persistence.*;

/**
 * 简历表
 */
@Entity
@Table(name = "resume")
public class Resume {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Long ID;
}
