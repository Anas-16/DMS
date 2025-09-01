package com.dms.repository;

import com.dms.model.Dissertation;
import com.dms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface DissertationRepository extends JpaRepository<Dissertation, UUID> {
    List<Dissertation> findByTitleContainingIgnoreCase(String keyword);
    List<Dissertation> findByUser(User user);
}
