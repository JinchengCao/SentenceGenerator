package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <Jincheng Cao>
 */
public class ListOfDefinitionsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link sentenceGenerator.ListOfDefinitions#toString()}.
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
		ListOfDefinitions ld1 = new ListOfDefinitions();
		ListOfDefinitions ld2 = new ListOfDefinitions();
		ld1.add(sd1);
		ld1.add(sd2);
		ld2.add(sd3);
		ld2.add(sd4);
		ld2.add(sd5);
		assertEquals("<intransitive verb> | <transitive verb> <noun phrase>",
				ld1.toString());
		assertEquals("big | red | hairy", ld2.toString());
	}

}
