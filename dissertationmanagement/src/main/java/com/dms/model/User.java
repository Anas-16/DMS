package com.dms.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Not needed if Supabase handles it, just keep placeholder

    @Column(nullable = false)
    private String role; // STUDENT or ADMIN
}
