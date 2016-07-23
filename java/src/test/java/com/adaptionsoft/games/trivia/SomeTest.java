package com.adaptionsoft.games.trivia;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

public class SomeTest {

	@Test
	public void true_is_true() throws Exception {
		assertTrue(false);
	}

	@Test
	public void testGoldenMaster() throws IOException {
		File runResults = new File("/var/tmp/runresults.txt");
		System.setOut(new PrintStream(new FileOutputStream(runResults)));
		GameRunner.runTheGame(new Random(1));
		assertThat(new String(Files.readAllBytes(runResults.toPath())), is(new String(Files.readAllBytes(new File("/var/tmp/goldenmaster.txt").toPath()))));
	}
}
