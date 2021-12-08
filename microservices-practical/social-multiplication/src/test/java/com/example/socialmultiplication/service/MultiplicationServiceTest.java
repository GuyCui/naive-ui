package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

  private MultiplicationServiceImpl multiplicationServiceImpl;

  /**
   * MockBen: 让 Spring 注入一个 RandomGeneratorService bean 的一个 mock，而不是搜寻这个接口的合适实现。
   */
  @Mock
  private RandomGeneratorService randomGeneratorService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
  }

  //@Resource
  //private MultiplicationService multiplicationService;

  @Test
  public void createRandomMultiplication() {
    given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

    Multiplication randomMultiplication = multiplicationServiceImpl.createRandomMultiplication();

    assertThat(randomMultiplication.getFactorA()).isEqualTo(50);
    assertThat(randomMultiplication.getFactorB()).isEqualTo(30);
    assertThat(randomMultiplication.getResult()).isEqualTo(1500);
  }
}
