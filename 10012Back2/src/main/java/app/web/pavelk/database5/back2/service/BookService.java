package app.web.pavelk.database5.back2.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final CacheManager cacheManager;

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

    public String info() {
        StringBuilder sb = new StringBuilder();
        Collection<String> cacheNames = cacheManager.getCacheNames();
        sb.append("всего " + cacheNames.size());
        cacheNames.forEach(f -> sb.append("\nname " + f));
        String s = sb.toString();
        System.out.println(s);
        return s;
    }

    public void clearAll() {
        cacheManager.getCacheNames().forEach(f -> Optional.ofNullable(cacheManager.getCache(f)).ifPresent(Cache::clear));
    }

}