package ru.mirea.sdk.entity.web;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(schema = "web", name = "report")
public class Report {
    @Id
    UUID id;
}
