package com.sparta.schedulemanagerproject.repository;

import com.sparta.schedulemanagerproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
