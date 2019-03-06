package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    PersonRepo personRepo;

    @RequestMapping("/")
    public String index(Model model)
    {
        //Add a person
        Person person = new Person();
        person.setName("Stephen Bullock");



        //create a pet
        Pet pet = new Pet();
        pet.setName("Harper");
        pet.setSpecies("Dog");



        //Add the pets to an empty list
        Set<Pet> pets = new HashSet<Pet>();
        pets.add(pet);

        Pet pet2 = new Pet();
        pet2.setName("Mr. Segal");
        pet2.setSpecies("Cat");
        pets.add(pet2);

        //Add the list of pets to the person's pets list
        person.setPets(pets);

        //Save the person to the database
        personRepo.save(person);

        //Grab all the persons from the database and send them to the template
        model.addAttribute("people", personRepo.findAll());
        return "index";
    }

}
