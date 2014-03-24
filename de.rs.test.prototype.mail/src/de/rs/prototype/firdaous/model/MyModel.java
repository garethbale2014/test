package de.rs.prototype.firdaous.model;

import java.util.ArrayList;
import java.util.List;

public class MyModel {

  private static MyModel model;
  private List<PersonMail> persons = new ArrayList<PersonMail>();

  private MyModel() {
    PersonMail person = new PersonMail("Hans", "Nase");
    persons.add(person);
    person = new PersonMail("Jim", "Knopf");
    persons.add(person);
  }

  public static MyModel getInstance() {
    if (model == null) {
      model = new MyModel();
    }
    return model;
  }

  public List<PersonMail> getPersons() {
    return persons;
  }

  public PersonMail getPersonById(int id) {
    for (PersonMail person : persons) {
      if (person.getId() == id) {
        System.out.println("returned");
        return person;
      }
    }
    return null;
  }
}