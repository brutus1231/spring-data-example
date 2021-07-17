package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;
import pl.sda.model.PersonEntity;
import pl.sda.repository.PersonRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        PersonEntity person1 = createPerson("Marcin", "Nowak", "83100213556");
        PersonEntity person2 = createPerson("Aleksandra", "Kowalska", "99010215333");
        PersonEntity person3 = createPerson("Kasia", "Wiśniewska", "05860344511");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        personRepository.findAll().forEach(System.out::println);

        System.out.println("findFirstByPesel: " + personRepository.findFirstByPesel("83100213556"));

        System.out.println("findFirstByPeselContains: " + personRepository.findFirstByPeselContains("02135"));

        System.out.println("findFirstByPeselContainsNative: " + personRepository.findFirstByPeselContainsNative("60344"));

        //System.out.println("findFirstByPesel: " + personRepository.findFirstByPesel("83100213556"));

        ((ConfigurableApplicationContext)context).close();
    }

    private static PersonEntity createPerson(String firstName, String lastName, String pesel) {
        return PersonEntity.builder().firstName(firstName).lastName(lastName).pesel(pesel).build();
    }
}
