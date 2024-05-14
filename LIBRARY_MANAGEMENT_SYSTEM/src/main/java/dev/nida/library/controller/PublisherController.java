package dev.nida.library.controller;

/**
 * @author Nida Başer
 * May 2024
 */

import dev.nida.library.dto.response.PublisherResponse;
import dev.nida.library.entity.Publisher;
import dev.nida.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherResponse> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponse getById(@PathVariable("id") Long id) {
        return publisherService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher) {
        return publisherService.create(publisher);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@PathVariable Long id, @RequestBody Publisher newPublisher) {
        return publisherService.update(id, newPublisher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        publisherService.deleteById(id);
    }

}