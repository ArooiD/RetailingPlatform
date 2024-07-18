package ru.mirea.sdk.entity.showcase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "showcase", name = "promo")
@RequiredArgsConstructor
public class Promo {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();
    @Column(name = "name")
    private String name;
    @Column(name = "sale")
    private Double sale;
    @Column(name = "startTime")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Date startTime;
    @Column(name = "endTime")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Date endTime;
}
