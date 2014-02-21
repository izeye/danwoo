package com.izeye.danwoo.core.bot.demo.eliza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

public class ElizaEngineTest {

	private ElizaEngine elizaEngine;

	@Before
	public void setUp() throws FileNotFoundException {
		elizaEngine = new ElizaEngine();

		File scriptFile = ResourceUtils
				.getFile("classpath:com/izeye/danwoo/core/bot/demo/eliza/eliza_script.json");
		elizaEngine.load(scriptFile);
	}

	@Test
	public void sorry() {
		String input = "I'm sorry to hear that.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void remember() throws FileNotFoundException {
		String input = "Should I remember who you are?";
		repeatBeforeDeplicate(input);

		input = "Do you remember who I am?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void what() {
		String input = "What is your name?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void testIf() {
		String input = "If I were you.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void dreamed() {
		String input = "I dreamed you.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void dream() {
		String input = "I have a dream.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void how() {
		String input = "How are you?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void when() {
		String input = "When will you leave?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void alike() {
		String input = "We are alike.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void yes() {
		String input = "Yes.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void no() {
		String input = "No.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void my() {
		String input = "My pleasure.";
		repeatBeforeDeplicate(input);

		// Test memory.
		input = "Wow.";
		respond(input);

		// Test synonym.
		input = "My wife is a teacher.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void perhaps() {
		String input = "Perhaps, you're not a human.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void name() {
		String input = "His name is Johnny.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void deutsch() {
		String input = "deutsch";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void francais() {
		String input = "francais";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void italiano() {
		String input = "italiano";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void espanol() {
		String input = "espanol";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void hello() {
		String input = "Hello.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void computer() {
		String input = "Hey, computer.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void am() {
		String input = "Am I lovely?";
		repeatBeforeDeplicate(input);

		input = "I am a boy.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void are() {
		String input = "Are you a computer?";
		repeatBeforeDeplicate(input);

		input = "Some people are kind.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void your() {
		String input = "Is this your concern?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void was() {
		String input = "Was I rude?";
		repeatBeforeDeplicate(input);

		input = "I was rude.";
		repeatBeforeDeplicate(input);

		input = "Was you rude?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void i() {
		String input = "I want a computer.";
		repeatBeforeDeplicate(input);

		input = "I'm very sad.";
		repeatBeforeDeplicate(input);

		input = "I'm very happy.";
		repeatBeforeDeplicate(input);

		input = "I was very happy.";
		repeatBeforeDeplicate(input);

		input = "I believe I can do it.";
		repeatBeforeDeplicate(input);

		input = "I believe you can do it.";
		repeatBeforeDeplicate(input);

		input = "I'm bored";
		repeatBeforeDeplicate(input);

		input = "I can't do it.";
		repeatBeforeDeplicate(input);

		input = "I don't know.";
		repeatBeforeDeplicate(input);

		input = "I feel tired.";
		repeatBeforeDeplicate(input);

		input = "I love you.";
		repeatBeforeDeplicate(input);

		input = "I will go.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void you() {
		String input = "You remind me of my friend.";
		repeatBeforeDeplicate(input);

		input = "You are a computer.";
		repeatBeforeDeplicate(input);

		input = "You love me.";
		repeatBeforeDeplicate(input);

		input = "You can do it.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void can() {
		String input = "Can you fly?";
		repeatBeforeDeplicate(input);

		input = "Can I fly?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void because() {
		String input = "Because of you.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void why() {
		String input = "Why don't you sleep?";
		repeatBeforeDeplicate(input);

		input = "Why can't I sleep?";
		repeatBeforeDeplicate(input);

		input = "Why?";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void everyone() {
		String input = "Everyone loves me.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void everybody() {
		String input = "Everybody loves me.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void nobody() {
		String input = "Nobody loves me.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void noone() {
		String input = "Noone loves me.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void always() {
		String input = "He's always happy.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void like() {
		String input = "He is like his mother.";
		repeatBeforeDeplicate(input);
	}

	@Test
	public void none() {
		String input = "A.";
		repeatBeforeDeplicate(input);
	}

	private void respond(String input) {
		System.out.println("Input: " + input);
		String output = elizaEngine.respond(input);
		System.out.println("Output: " + output);
	}

	private void repeatBeforeDeplicate(String input) {
		System.out.println("Input: " + input);
		System.out.println("Output: ");
		Set<String> outputSet = new HashSet<String>();
		while (true) {
			String output = elizaEngine.respond(input);
			if (outputSet.contains(output)) {
				break;
			}
			System.out.println(output);

			outputSet.add(output);
		}
	}

}
