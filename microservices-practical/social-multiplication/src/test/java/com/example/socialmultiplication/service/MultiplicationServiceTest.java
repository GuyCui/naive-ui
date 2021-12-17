package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.doMain.User;
import com.example.socialmultiplication.event.EventDispatcher;
import com.example.socialmultiplication.event.MultiplicationSolvedEvent;
import com.example.socialmultiplication.repository.MultiplicationResultAttemptRepository;
import com.example.socialmultiplication.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

  private MultiplicationServiceImpl multiplicationServiceImpl;

  /** MockBen: 让 Spring 注入一个 RandomGeneratorService bean 的一个 mock，而不是搜寻这个接口的合适实现。 */
  @Mock private RandomGeneratorService randomGeneratorService;

  @Mock private MultiplicationResultAttemptRepository attemptRepository;

  @Mock private UserRepository userRepository;

  @Mock private EventDispatcher eventDispatcher;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    multiplicationServiceImpl =
        new MultiplicationServiceImpl(
            randomGeneratorService, attemptRepository, userRepository, eventDispatcher);
  }

  // @Resource
  // private MultiplicationService multiplicationService;

  @Test
  public void createRandomMultiplication() {
    given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

    Multiplication randomMultiplication = multiplicationServiceImpl.createRandomMultiplication();

    assertThat(randomMultiplication.getFactorA()).isEqualTo(50);
    assertThat(randomMultiplication.getFactorB()).isEqualTo(30);
    // assertThat(randomMultiplication.getResult()).isEqualTo(1500);
  }

  @Test
  public void checkCorrectAttemptTest() {
    // given
    Multiplication multiplication = new Multiplication(50, 60);
    User user = new User("guy");
    MultiplicationResultAttempt attempt =
        new MultiplicationResultAttempt(user, multiplication, 3000, false);
    MultiplicationResultAttempt verifiedArrempt =
        new MultiplicationResultAttempt(user, multiplication, 3000, true);
    MultiplicationSolvedEvent event =
        new MultiplicationSolvedEvent(attempt.getId(), attempt.getUser().getId(), true);
    given(userRepository.findByAlias("guy")).willReturn(Optional.empty());

    // when
    boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

    // assert
    assertThat(attemptResult).isTrue();
    verify(attemptRepository).save(verifiedArrempt);
    verify(eventDispatcher).send(eq(event));
  }

  @Test
  public void checkWrongAttemptTest() {
    // given
    Multiplication multiplication = new Multiplication(50, 60);
    User user = new User("cui");
    MultiplicationResultAttempt attempt =
        new MultiplicationResultAttempt(user, multiplication, 3010, false);
    MultiplicationSolvedEvent event =
        new MultiplicationSolvedEvent(attempt.getId(), attempt.getUser().getId(), false);
    given(userRepository.findByAlias("cui")).willReturn(Optional.empty());
    // when
    boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

    // assert
    assertThat(attemptResult).isFalse();
    verify(attemptRepository).save(attempt);
    verify(eventDispatcher).send(eq(event));
  }
}
