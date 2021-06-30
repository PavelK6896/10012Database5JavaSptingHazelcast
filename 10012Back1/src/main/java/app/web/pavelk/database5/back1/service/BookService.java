package app.web.pavelk.database5.back1.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Cacheable("books")
    public String getBookNameByIsbn(String isbn) {
        System.out.println("getBookNameByIsbn");
        return findBookInSlowSource(isbn);
    }

    private String findBookInSlowSource(String isbn) {
        System.out.println("findBookInSlowSource");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Sample Book Name " + isbn;
    }

    @Cacheable("b")
    public String getB() {
        System.out.println("getBookNameByIsbn");
        return "b";
    }
}