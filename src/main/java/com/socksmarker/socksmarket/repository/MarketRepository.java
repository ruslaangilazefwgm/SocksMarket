package com.socksmarker.socksmarket.repository;

import com.socksmarker.socksmarket.model.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends JpaRepository<Sock, Long> {

}
