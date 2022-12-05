package org.etu.java.labs.service;

import org.etu.java.labs.controller.IntelligentParkingSystemControllerImpl;
import org.etu.java.labs.entity.IntelligentParkingSystem;
import org.etu.java.labs.repository.IntelligentParkingSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class IntelligentParkingSystemService implements GenericService<IntelligentParkingSystem> {
    @Autowired
    private IntelligentParkingSystemRepository repository;
    @Autowired
    private MessageSource messages;


    @Override
    public List<IntelligentParkingSystem> getAll(Locale locale) {
        var items = repository.findAll();

        return items.stream().map(
            item -> item.add(setupHateoasLinks(item, locale))
        ).collect(Collectors.toList());
    }

    @Override
    public IntelligentParkingSystem getById(String id, Locale locale) {
        var item = repository.findById(id);

        return item.isPresent() ? item.get().add(setupHateoasLinks(item.get(), locale)) : null;
    }

    @Override
    public String create(IntelligentParkingSystem item, Locale locale) {
        var createdItem = repository.save(item);

        return String.format(
            messages.getMessage("ips.create.message", null, locale),
            createdItem
        );
    }

    @Override
    public String update(IntelligentParkingSystem item, Locale locale) {
        var updatedItem = repository.save(item);

        return String.format(
            messages.getMessage("ips.update.message", null, locale),
            updatedItem
        );
    }

    @Override
    public String delete(String id, Locale locale) {
        repository.deleteById(id);

        return String.format(
            messages.getMessage("ips.delete.message", null, locale),
            id
        );
    }



    private Link[] setupHateoasLinks(IntelligentParkingSystem item, Locale locale) {
        return new Link[] {
            linkTo(
                methodOn(IntelligentParkingSystemControllerImpl.class).getAll(null)
            ).withSelfRel().withSelfRel(),

            linkTo(
                methodOn(IntelligentParkingSystemControllerImpl.class).create(item, null)
            ).withRel(messages.getMessage("ips.create.link", null, locale)),

            linkTo(
                methodOn(IntelligentParkingSystemControllerImpl.class).update(item, null)
            ).withRel(messages.getMessage("ips.update.link", null, locale)),

            linkTo(
                methodOn(IntelligentParkingSystemControllerImpl.class).delete(item.getId(), null)
            ).withRel(messages.getMessage("ips.delete.link", null, locale))
        };
    }
}
