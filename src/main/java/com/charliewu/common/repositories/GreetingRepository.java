package com.charliewu.common.repositories;

import com.charliewu.common.domain.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Charlie Wu on 2017-02-08.
 */
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
