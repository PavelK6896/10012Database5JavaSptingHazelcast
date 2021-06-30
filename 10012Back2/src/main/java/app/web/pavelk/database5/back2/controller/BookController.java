package app.web.pavelk.database5.back2.controller;

import app.web.pavelk.database5.back2.service.BookService;
import com.hazelcast.core.HazelcastInstance;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    @PostMapping("/{i}")
    public String postI(@PathVariable("i") String i) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        hazelcastMap.put(i, i);
        return i;
    }

    @GetMapping("/{i}")
    public String getI(@PathVariable("i") String i) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
        return hazelcastMap.get(i);
    }

}