package com.viktor.QuestionService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class QuestionServiceApplicationTests {

	private Calculator calculator = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		long actualRes = 14;
		long finalResult = calculator.sum(3,4,7);

		assert(actualRes == finalResult);

		assertThat(actualRes).isEqualTo(finalResult);

	}

}
