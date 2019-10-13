package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.repository.AuthorRepository;
import guru.springframework.spring5webapp.model.repository.BookRepository;
import guru.springframework.spring5webapp.model.repository.PublisherRepository;

//Need this annotation to know its a component so it can be wired
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	//adding the repos
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	//takes them in at run time. Component is autowired based from this constructor
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
	}
	
	private void initData() {
		//saving values to both repositories.
		Author duke = new Author("Duke","Dog");
		
		Publisher pb = new Publisher("Penguin","123 USA Way");
		publisherRepository.save(pb);
		Book ddd = new Book("Diners Drive in and Dive","1234",pb);
		duke.getBooks().add(ddd);
		ddd.getAuthors().add(duke);
		
		authorRepository.save(duke);
		bookRepository.save(ddd);
		
		Author dukas = new Author("Dukas","Sprouts");
		Publisher pp = new Publisher("Syndicate","654 NWA Dr");
		publisherRepository.save(pp);
		Book hl = new Book("Clifford Goes Out","666",pp);
		dukas.getBooks().add(hl);
		hl.getAuthors().add(dukas);
		
		authorRepository.save(dukas);
		bookRepository.save(hl);
	}
}
