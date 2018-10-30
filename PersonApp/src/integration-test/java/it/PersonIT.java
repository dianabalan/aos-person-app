package it;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import DAL.PersonRepository;
import model.Person;

@Category(IntegrationTest.class)
public class PersonIT extends Mockito {
// conventie: numele metodelor in java (fie ca sunt parte din test classes sau nu) incep cu litera mica si sunt camelCase. in cazul tau: personServletPostIT
	@Test
	public void PersonServlet_Post_IT() throws ServletException, IOException {

		Person person = new Person();
		person.setName("testIT");
		person.setEmail("testIT");

		PersonRepository repo = new PersonRepository("PersonPU");

		person = repo.createOrUpdate(person);

		assertNotEquals(0, person.getId());

		/*HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("user_name")).thenReturn("usernameIT");
		when(request.getParameter("email")).thenReturn("it@test.com");

		new PersonServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("user_name");
		verify(request, atLeast(1)).getParameter("email");

		assertEquals(person.getId(), (int) request.getAttribute("id_it_test"));*/
	}
}
