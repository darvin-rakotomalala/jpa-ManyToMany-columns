package com.poc.repository;

import com.poc.model.domain.BookPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookPublisherRepository extends JpaRepository<BookPublisher, Long> {
    @Query("FROM BookPublisher bp WHERE lower(bp.format) LIKE lower(concat('%', :format,'%'))")
    Page<BookPublisher> searchByFormat(@Param("format") String format, Pageable page);
}
