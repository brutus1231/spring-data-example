package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;
import pl.sda.model.DepartmentEntity;
import pl.sda.model.PersonEntity;
import pl.sda.repository.DepartmentRepository;
import pl.sda.repository.PersonRepository;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

        DepartmentEntity departmentIt = createDepartment("IT");
        DepartmentEntity departmentMarketing = createDepartment("Marketing");
        DepartmentEntity depertment1 = departmentRepository.save(departmentIt);
        DepartmentEntity depertment2 = departmentRepository.save(departmentMarketing);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        PersonEntity person1 = createPerson("Marcin", "Nowak", "83100213556", depertment1);
        PersonEntity person2 = createPerson("Aleksandra", "Kowalska", "99010215333", depertment2);
        PersonEntity person3 = createPerson("Kasia", "Wiśniewska", "05860344511", depertment2);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        personRepository.findAll().forEach(System.out::println);

        System.out.println("findFirstByPesel: " + personRepository.findFirstByPesel("83100213556"));

        System.out.println("findFirstByPeselContains: " + personRepository.findFirstByPeselContains("02135"));

        System.out.println("findFirstByPeselContainsNative: " + personRepository.findFirstByPeselContainsNative("60344"));

        System.out.println("findFirstByPeselAndDepartment: " + personRepository.findFirstByPeselAndDepartment("05860344511", "Marketing"));


        //System.out.println("findFirstByPesel: " + personRepository.findFirstByPesel("83100213556"));

        ((ConfigurableApplicationContext)context).close();
    }

    private static DepartmentEntity createDepartment(String name) {
        return DepartmentEntity.builder().name(name).build();
    }

    private static PersonEntity createPerson(String firstName, String lastName, String pesel,
                                             DepartmentEntity depertment) {
        return PersonEntity.builder()
                .firstName(firstName).lastName(lastName)
                .pesel(pesel).department(depertment)
                .build();
    }
}
