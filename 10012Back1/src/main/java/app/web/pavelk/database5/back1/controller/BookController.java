package app.web.pavelk.database5.back1.controller;

import app.web.pavelk.database5.back1.service.BookService;
import com.hazelcast.core.HazelcastInstance;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final HazelcastInstance hazelcastInstance;

    @GetMapping("/{isbn}/c")
    public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookNameByIsbn(isbn);
    }

    @GetMapping("/b")
    public String getB() {
        return bookService.getB();
    }

    @PostMapping("/map/{i}")
    public Map<String, String> postI(@PathVariable("i") String i) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        hazelcastMap.put(String.valueOf(ThreadLocalRandom.current().nextInt()), i);
        return hazelcastMap;
    }

    @GetMapping("/map")
    public Map<String, String> getMap() {
        return hazelcastInstance.getMap("my-map");
    }

    @GetMapping("/map/{i}")
    public String getI(@PathVariable("i") String i) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        return hazelcastMap.get(i);
    }

    @GetMapping("/clear")
    public String clear() {
        bookService.clearCache();
        return "ok";
    }

    @GetMapping("/clearAll")
    public String clearAll() {
        bookService.clearAll();
        return "ok";
    }

    @GetMapping("/info")
    public String info() {
        return bookService.info();
    }


}