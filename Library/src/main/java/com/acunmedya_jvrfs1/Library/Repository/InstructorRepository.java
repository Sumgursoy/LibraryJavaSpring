package com.acunmedya_jvrfs1.Library.Repository;

import com.acunmedya_jvrfs1.Library.entity.Instructer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructer, Integer> {
} 