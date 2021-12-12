package com.example.socialmultiplication.controller;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.doMain.User;
import com.example.socialmultiplication.service.MultiplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.socialmultiplication.controller.MultiplicationResultAttemptController.ResultResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {
  @MockBean private MultiplicationService multiplicationService;

  @Autowired private MockMvc mvc;

  // 这个对象会被下面的 initFields 方法神奇地初始化。
  private JacksonTester<MultiplicationResultAttempt> jsonResult;
  private JacksonTester<ResultResponse> jsonResponse;

  @Before
  public void setUp() {
    JacksonTester.initFields(this, new ObjectMapper());
  }

  @Test
  public void postResultReturnCorrect() throws Exception {
    genericParameterizedTest(true);
  }

  @Test
  public void postResultReturnNotCorrect() throws Exception {
    genericParameterizedTest(false);
  }

  private void genericParameterizedTest(final boolean correct) throws Exception {
    // given
    given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class)))
        .willReturn(correct);

    User user = new User("Guy");

    Multiplication multiplication = new Multiplication(50, 70);
    MultiplicationResultAttempt attempt =
        new MultiplicationResultAttempt(user, multiplication, 3500, correct);

    // when
    MockHttpServletResponse response =
        mvc.perform(
                post("/results")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonResult.write(attempt).getJson()))
            .andReturn()
            .getResponse();

    // then
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.getContentAsString())
        .isEqualTo(
            jsonResult
                .write(
                    new MultiplicationResultAttempt(
                        attempt.getUser(),
                        attempt.getMultiplication(),
                        attempt.getResultAttempt(),
                        correct))
                .getJson());
  }
}
