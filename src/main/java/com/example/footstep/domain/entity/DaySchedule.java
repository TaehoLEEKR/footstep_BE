package com.example.footstep.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class DaySchedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayScheduleId;
    @Column(columnDefinition = "NVARCHAR(8) NOT NULL")
    private String planDate;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String content;


    @ManyToOne
    @JoinColumn(name = "shareId")
    private ShareRoom shareRoom;
}
