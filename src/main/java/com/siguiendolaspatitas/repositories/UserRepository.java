package com.siguiendolaspatitas.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByOrderByCreatedAtDesc();
    List<User> findAllByOrderByUpdatedAtDesc();
    List<User> findAllByOrderByNameAsc();
    List<User> findAllByOrderByNameDesc();

}
