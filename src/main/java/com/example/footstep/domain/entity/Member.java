package com.example.footstep.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AuditOverride(forClass = BaseTimeEntity.class)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(columnDefinition = "NVARCHAR(30) NOT NULL")
    private String loginEmail;
    @Column(columnDefinition = "NVARCHAR(30) NOT NULL")
    private String nickname;
    @Column(columnDefinition = "NVARCHAR(255) NOT NULL")
    private String password;
    @Column(columnDefinition = "CHAR(1) NOT NULL")
    private String gender;
}
