package com.dndgame.gamecore;

import org.springframework.boot.SpringApplication;

public class TestGameCoreApplication {

	public static void main(String[] args) {
		SpringApplication.from(GameCoreApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
