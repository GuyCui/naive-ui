package com.microservices.gamification.repository;

import com.microservices.gamification.domain.BadgeCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Guy Cui
 */
public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {
    /**
     * @param userId 用户id
     *
     * @return {@code List<BadgeCard>}
     */
    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final Long userId);
}
