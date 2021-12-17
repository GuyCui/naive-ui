package com.microservices.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 与某个特定用户关联的徽章，用户在特定时间赢取它
 * @author Guy Cui
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class BadgeCard {
    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private final Long badgeId;
    private final Long userId;
    private final long badgeTimestamp;
    private final Badge badge;

    public BadgeCard() {
        this(null, null, 0, null);
    }

    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, System.currentTimeMillis(), badge);
    }
}
