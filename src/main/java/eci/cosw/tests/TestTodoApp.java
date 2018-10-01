package eci.cosw.tests;

/**import eci.cosw.data.AppConfiguration;
import eci.cosw.data.model.Todo;
import eci.cosw.data.CustomerRepository;
import eci.cosw.data.TodoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class TestTodoApp {

    @Autowired
    TodoRepository todoRepository;

    @Before
    public void init() {
        todoRepository.deleteAll();
        // ADD USERS
        todoRepository.save(new Todo("Seminario SEGI+", 3, new Date(2018, 9, 30), "danieldaleman@hotmail.com", "Pending"));
        todoRepository.save(new Todo("Terminar laboratorios COSW", 9, new Date(2018, 9, 30), "danieldaleman@hotmail.com", "Pending"));
        todoRepository.save(new Todo("Leer libros", 5, new Date(2018, 9, 30), "juandaleman@hotmail.com", "Pending"));
    }

    @Test
    public void testTodosFoundByResponsible() {
        List<Todo> todoList = todoRepository.findByResponsible("danieldaleman@hotmail");
        assertEquals(2, todoList.size());
    }
}**/