package com.tg.codingtest.preferencecreator.repository.entity;

import com.tg.codingtest.preferencecreator.common.enums.PreferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class for customer preference
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PREFERENCE")
public class PreferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private CustomerEntity customer;

    private PreferenceType preferenceType;

    private Long modifiedBy;
    private Long createdBy;
    private LocalDateTime creationTime;
    private LocalDateTime modifiedTime;


}
