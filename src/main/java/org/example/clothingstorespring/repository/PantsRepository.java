package org.example.clothingstorespring.repository;


import org.example.clothingstorespring.model.Pants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsRepository extends JpaRepository<Pants, Long> {

}
