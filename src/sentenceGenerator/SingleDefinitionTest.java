package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Jincheng Cao>
 */
public class SingleDefinitionTest {

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link sentenceGenerator.SingleDefinition#toString()}.
	 */
	@Test
	public final void testToString() {
		// fail("Not yet implemented"); // TODO
		SingleDefinition sd1 = new SingleDefinition();
		SingleDefinition sd2 = new SingleDefinition();
		SingleDefinition sd3 = new SingleDefinition();
		SingleDefinition sd4 = new SingleDefinition();
		SingleDefinition sd5 = new SingleDefinition();
		sd1.add("<intransitive verb>");
		sd2.add("<transitive verb>");
		sd2.add("<noun phrase>");
		sd3.add("big");
		sd4.add("red");
		sd5.add("hairy");
		assertEquals("<intransitive verb>", sd1.toString());
		assertEquals("<transitive verb> <noun phrase>", sd2.toString());
		assertEquals("big", sd3.toString());
		assertEquals("red", sd4.toString());
		assertEquals("hairy", sd5.toString());

	}

}
