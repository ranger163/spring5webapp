package me.inassar.spring5webapp.bootstrap;

import me.inassar.spring5webapp.model.Author;
import me.inassar.spring5webapp.model.Book;
import me.inassar.spring5webapp.model.Publisher;
import me.inassar.spring5webapp.repositories.AuthorRepository;
import me.inassar.spring5webapp.repositories.BookRepository;
import me.inassar.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Ahmed Nassar
        Author ahmed = new Author("Ahmed", "Nassar");
        Publisher publisher1=new Publisher("Harper Collins","12, happy st");
        publisherRepository.save(publisher1);
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        ahmed.getBooks().add(ddd);
        ddd.getAuthors().add(ahmed);

        authorRepository.save(ahmed);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2=new Publisher("Worx","17, highway st");
        publisherRepository.save(publisher2);
        Book noEJB = new Book("J2EE Development without JEB", "2233", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
