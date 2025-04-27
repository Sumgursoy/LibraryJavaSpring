package com.acunmedya_jvrfs1.Library.Repository;

import com.acunmedya_jvrfs1.Library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userEntityRepository extends JpaRepository<User, Integer> {
} 