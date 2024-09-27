package org.example.clothingstorespring.repository;


import org.example.clothingstorespring.entity.Jacket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JacketRepository extends JpaRepository<Jacket, Long> {

}
