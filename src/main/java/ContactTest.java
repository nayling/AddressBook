import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContactTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSetName() {
		Contact contact = new Contact();
		contact.setName("Natalie");
		assertEquals("Natalie", contact.getName());
	}
	
	@Test(expected=Error.class)
	public void testNameShort() {
		Contact contact = new Contact();
		contact.setName("N");
	}
	
	@Test(expected=Error.class)
	public void testNameLong() {
		Contact contact = new Contact();
		contact.setName("Add the optional expected attribute to the @Test annotation. The following is an example test that");
	}
	
	@Test(expected=Error.class)
	public void testSetAddr() {
		Contact contact = new Contact();
		contact.setAddress("123 Lucky St.");
		assertEquals("123 Lucky St.", contact.getAddress());
	}

	@Test(expected=Error.class)
	public void testAddrShort() {
		Contact contact = new Contact();
		contact.setAddress("1 L");
	}
	
	@Test(expected=Error.class)
	public void testAddrPattern() {
		Contact contact = new Contact();
		contact.setAddress("1234@ Lucky $t");
	}

	@Test
	public void testSetPhone() {
		Contact contact = new Contact();
		contact.setPhone("(703)-123-5555");
		assertEquals("(703)-123-5555", contact.getPhone());
	}
	
	@Test(expected=Error.class)
	public void testPhoneLong() {
		Contact contact = new Contact();
		contact.setPhone("703-1234-5555");
	}
	
	@Test(expected=Error.class)
	public void testPhonePattern() {
		Contact contact = new Contact();
		contact.setPhone("1234$67&92");
	}

	@Test
	public void testSetEmail() {
		Contact contact = new Contact();
		contact.setEmail("bob@generic.net");
		assertEquals("bob@generic.net", contact.getEmail());
	}
	
	@Test(expected=Error.class)
	public void testEmailShort() {
		Contact contact = new Contact();
		contact.setEmail("n@m.c");
	}
	
	@Test(expected=Error.class)
	public void testEmailPattern() {
		Contact contact = new Contact();
		contact.setEmail("@generic.bob.net");
	}

}
