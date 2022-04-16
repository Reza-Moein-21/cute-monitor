package cutemonitor.db.test;

import gmail.rezamoeinpe.cutemonitor.db.CuteMonitorDBModule;
import gmail.rezamoeinpe.cutemonitor.db.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ContextConfiguration(classes = CuteMonitorDBModule.class)
public class JobRepositoryTest {


    @Autowired
    JobRepository repository;

    @Test
    void insertOne() {
        assertThat(repository.findAll()).isEmpty();
    }
}
