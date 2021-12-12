package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.doMain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

  private MultiplicationServiceImpl multiplicationServiceImpl;

  /** MockBen: 让 Spring 注入一个 RandomGeneratorService bean 的一个 mock，而不是搜寻这个接口的合适实现。 */
  @Mock private RandomGeneratorService randomGeneratorService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
  }

  // @Resource
  // private MultiplicationService multiplicationService;

  @Test
  public void createRandomMultiplication() {
    given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

    Multiplication randomMultiplication = multiplicationServiceImpl.createRandomMultiplication();

    assertThat(randomMultiplication.getFactorA()).isEqualTo(50);
    assertThat(randomMultiplication.getFactorB()).isEqualTo(30);
    //assertThat(randomMultiplication.getResult()).isEqualTo(1500);
  }

  @Test
  public void checkCorrectAttemptTest() {
    //given
    Multiplication multiplication = new Multiplication(50,60);
    User user = new User("guy");
    MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000, false);

    // when
    boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

    // assert
    assertThat(attemptResult).isTrue();
  }

  @Test
  public void checkWrongAttemptTest() {
    // given
    Multiplication multiplication = new Multiplication(50, 60);
    User user = new User("cui");
    MultiplicationResultAttempt attempt =
        new MultiplicationResultAttempt(user, multiplication, 3010, false);
    // when
    boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

    // assert
    assertThat(attemptResult).isFalse();
  }
}
