package com.dndgame.gamecore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GameCoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
