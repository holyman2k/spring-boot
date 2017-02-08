package com.charliewu.common.repositories;

import com.charliewu.common.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by charliewu on 7/2/17.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
