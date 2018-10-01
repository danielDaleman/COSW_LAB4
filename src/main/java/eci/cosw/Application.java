package eci.cosw;

import eci.cosw.data.AppConfiguration;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import eci.cosw.data.CustomerRepository;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));
		
		 todoRepository.deleteAll();

        todoRepository.save(new Todo("TAREA 1", 9, new Date(2018, 9, 18), "danieldaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 2", 8, new Date(2018 - 1900, 8, 17), "danieldaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 3", 7, new Date(2018 - 1900, 8, 7), "danieldaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 4", 8, new Date(2018 - 1900, 9, 5), "danieldaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 5", 4, new Date(2018 - 1900, 8, 20), "danieldaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 6", 7, new Date(2018 - 1900, 11, 20), "danieldaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 7", 7, new Date(2018 - 1900, 11, 20), "danieldaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 8", 8, new Date(2018 - 1900, 8, 27), "juandaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 9", 1, new Date(2018 - 1900, 9, 15), "juandaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 10", 4, new Date(2018 - 1900, 8, 5), "juandaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 11", 1, new Date(2018 - 1900, 8, 13), "juandaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 12", 5, new Date(2018 - 1900, 8, 12), "juandaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 13", 1, new Date(2018 - 1900, 8, 12), "juandaleman@mail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 14", 3, new Date(2018 - 1900, 8, 16), "juandaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 15", 2, new Date(2018 - 1900, 4, 13), "juandaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 16", 8, new Date(2018 - 1900, 11, 24), "nicolasdaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 17", 6, new Date(2018 - 1900, 8, 16), "nicolasdaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 18", 2, new Date(2018 - 1900, 8, 16), "nicolasdaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 19", 7, new Date(2018 - 1900, 9, 17), "nicolasdaleman@mail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 20", 9, new Date(2018 - 1900, 11, 12), "eduardaleman@hotmail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 21", 6, new Date(2018 - 1900, 7, 15), "eduardaleman@hotmail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 22", 8, new Date(2018 - 1900, 7, 25), "eduardaleman@hotmail.com", "Completed"));
        todoRepository.save(new Todo("TAREA 23", 1, new Date(2018 - 1900, 8, 10), "eduardaleman@hotmail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 24", 7, new Date(2018 - 1900, 8, 12), "eduardaleman@hotmail.com", "Pending"));
        todoRepository.save(new Todo("TAREA 25", 4, new Date(2018 - 1900, 8, 10), "eduardaleman@hotmail.com", "Completed"));


        userRepository.deleteAll();

        userRepository.save(new User("Daniel", "daniel@mail.com"));
        userRepository.save(new User("Felipe", "pipe@mail.com"));
        userRepository.save(new User("Juan", "juan@mail.com"));
        userRepository.save(new User("David", "david@mail.com"));
        userRepository.save(new User("Nicolas", "nico@mail.com"));
        userRepository.save(new User("Alexander", "alex@mail.com"));
        userRepository.save(new User("Eduard", "eduar@mail.com"));
        userRepository.save(new User("Alejandro", "alejo@mail.com"));
        userRepository.save(new User("Jonathan", "jonathan@mail.com"));
        userRepository.save(new User("Camilo", "camilo@mail.com"));
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
 
        /**System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
		
		System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
        System.out.println();**/
		
		//PUNTO 7
		Query expired = new Query();
        expired.addCriteria(Criteria.where("dueDate").lt(new Date(System.currentTimeMillis())));
        List<Todo> todos1 = mongoOperation.find(expired, Todo.class);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Todos that the dueDate has expired:");
        for(Todo todo: todos1){
            System.out.println("Description: " + todo.getDescription() + "  Due Date: " + todo.getDueDate());
        }
        System.out.println("--------------------------------------------------------------------------");
		
		Query assigned = new Query();
        assigned.addCriteria(Criteria.where("priority").gte(5).and("responsible").is("nicolasdaleman@mail.com"));
        List<Todo> todos2 = mongoOperation.find(assigned, Todo.class);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Todos that are assigned to given user and have priority greater equal to 5:");
        for(Todo todo: todos2){
            System.out.println(" Responsible: " + todo.getResponsible() + " Description: " + todo.getDescription()+ " Due Date: " + todo.getDueDate() + " Priority: " + todo.getPriority());
        }
        System.out.println("--------------------------------------------------------------------------");
		

		
		
		//FIN PUNTO 7


    }

}