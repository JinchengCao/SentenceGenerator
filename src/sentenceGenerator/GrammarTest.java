package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Jincheng Cao>
 */
public class GrammarTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link sentenceGenerator.Grammar#Grammar()}.
	 */
	@Test
	public final void testGrammar() {
		 // TODO
		Grammar g = new Grammar();
		assertTrue(g instanceof Grammar);
	}

	/**
	 * Test method for
	 * {@link sentenceGenerator.Grammar#addRule(java.lang.String)}.
	 */
	@Test
	public final void testAddRule() {
	   // TODO
		Grammar grammar = new Grammar();
		grammar.addRule("<sentence> ::= <noun phrase> <verb phrase>");
		assertEquals("<noun phrase> <verb phrase>", grammar.getDefinitions("<sentence>").get(0).toString());
		grammar.addRule("<pronoun> ::= he | she | it");
		grammar.addRule("<pronoun> ::= someone | everybody");
		assertEquals("he", grammar.getDefinitions("<pronoun>").get(0).toString());
		assertEquals("she", grammar.getDefinitions("<pronoun>").get(1).toString());
	}

	/**
	 * Test method for
	 * {@link sentenceGenerator.Grammar#getDefinitions(java.lang.String)}.
	 */
	@Test
	public final void testGetDefinitions() {
		// TODO
		Grammar grammar = new Grammar();
		grammar.addRule("<sentence> ::= <noun phrase> <verb phrase>");
		assertEquals("<noun phrase> <verb phrase>", grammar.getDefinitions("<sentence>").get(0).toString());
		grammar.addRule("<pronoun> ::= he | she | it");
		grammar.addRule("<pronoun> ::= someone | everybody");
		assertEquals("he", grammar.getDefinitions("<pronoun>").get(0).toString());
		assertEquals("she", grammar.getDefinitions("<pronoun>").get(1).toString());
	}

}
