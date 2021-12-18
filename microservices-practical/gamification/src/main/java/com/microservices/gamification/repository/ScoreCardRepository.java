package com.microservices.gamification.repository;

import com.microservices.gamification.domain.LeaderBoardRow;
import com.microservices.gamification.domain.ScoreCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 计分卡库
 *
 * @author Guy Cui
 */
public interface ScoreCardRepository extends CrudRepository<ScoreCard, Long> {
    /**
     * 获得用户的总分
     *
     * @param userId 用户id
     *
     * @return int
     */
    @Query("SELECT SUM(s.score) FROM ScoreCard s WHERE s.userId = :userId GROUP BY s.userId")
    int getTotalScoreForUser(@Param("userId") final Long userId);

    /**
     * 找到first10
     *
     * @return {@code List<LeaderBoardRow>}
     */
    @Query("SELECT NEW com.microservices.gamification.domain.LeaderBoardRow(s.userId, sum(s.score)) FROM ScoreCard s group by s.userId order by " +
            "sum" + "(s" + ".score) desc")
    List<LeaderBoardRow> findFirst10();

    /**
     * 时间戳desc找到通过用户id为分数
     *
     * @param userId 用户id
     *
     * @return {@code List<ScoreCard>}
     */
    List<ScoreCard> findByUserIdOrderByScoreTimestampDesc(final Long userId);
}
