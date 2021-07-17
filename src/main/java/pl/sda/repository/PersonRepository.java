package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findFirstByPesel(String pesel);

    @Query("select p from PersonEntity p where p.pesel like %:pesel% ")
    PersonEntity findFirstByPeselContains(@Param("pesel") String pesel);

    @Query(value = "select * from PERSON p where p.pesel like %:pesel% ", nativeQuery = true)
    PersonEntity findFirstByPeselContainsNative(@Param("pesel") String pesel);


}
