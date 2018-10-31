package jay.springframework.spring5webapp.bootstrap;

import jay.springframework.spring5webapp.model.Author;
import jay.springframework.spring5webapp.model.Book;
import jay.springframework.spring5webapp.model.Publisher;
import jay.springframework.spring5webapp.repositories.AuthorRepository;
import jay.springframework.spring5webapp.repositories.BookRepository;
import jay.springframework.spring5webapp.repositories.PublisherRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepositories publisherRepositories;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepositories publisherRepositories) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepositories.save(publisher);


        Author eric = new Author("eric", "evans");
        Book ddd = new Book("Domain Driven Design", "123$", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE dev without ejb", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
