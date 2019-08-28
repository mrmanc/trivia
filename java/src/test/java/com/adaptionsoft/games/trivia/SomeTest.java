package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SomeTest {

    @Test
    public void testGoldenMaster() throws Exception {

        ByteArrayOutputStream console = new ByteArrayOutputStream();
        System.setOut(new PrintStream(console));

        GameRunner.runTheGame(new Random(1));
//        String runResults = console.toString();
//        String goldenMaster = new String(Files.readAllBytes(new File("../goldenmaster.txt").toPath()));
//        assertThat(runResults, is(goldenMaster));

        assertThat(hash(console.toString()), is("E1CCC59934D33A4D15B4B37ADF19A617"));
    }

    private String hash(String runResults) throws NoSuchAlgorithmException {
        return DatatypeConverter.printHexBinary(
                MessageDigest.getInstance("MD5").digest(runResults.getBytes())
        ).toUpperCase();
    }
}
