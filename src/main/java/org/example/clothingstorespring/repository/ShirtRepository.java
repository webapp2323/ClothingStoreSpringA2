package org.example.clothingstorespring.repository;


import org.example.clothingstorespring.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long> {
    // JPA автоматично надає методи для CRUD
}


