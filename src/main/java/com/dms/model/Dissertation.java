package com.dms.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Dissertation {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private String fileLink;

    @ManyToOne
    private User user;

    private String status = "pending"; // pending, approved, rejected
}
