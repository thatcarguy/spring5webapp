package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.repository.AuthorRepository;
import guru.springframework.spring5webapp.model.repository.BookRepository;

//Need this annotation to know its a component so it can be wired
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	//adding the repos
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	//takes them in at run time. Component is autowired based from this constructor
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
	}
	
	private void initData() {
		//saving values to both repositories.
		Author duke = new Author("Duke","Dog");
		Book ddd = new Book("Diners Drive in and Dive","1234","Penguin");
		duke.getBooks().add(ddd);
		ddd.getAuthors().add(duke);
		
		authorRepository.save(duke);
		bookRepository.save(ddd);
		
		Author dukas = new Author("Dukas","Sprouts");
		Book hl = new Book("Clifford Goes Out","666","Ozzy");
		dukas.getBooks().add(hl);
		hl.getAuthors().add(dukas);
		
		authorRepository.save(dukas);
		bookRepository.save(hl);
	}
}
