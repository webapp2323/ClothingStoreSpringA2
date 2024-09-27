package org.example.clothingstorespring.repository;


import org.example.clothingstorespring.entity.Pants;
import org.example.clothingstorespring.entity.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsRepository extends JpaRepository<Pants, Long> {

}
