package com.korea.project.repository;

import com.korea.project.entity.Project;
import com.korea.project.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Timestamp;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findAllByOwner() {

        //Given
        User user = new User();
        user.setId(1);
        user.setFirstname("Didi");
        user.setLastname("Idiom");
        user.setUsername("didiom");
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
        user.setJoindate(currentTimestamp);
        user.setPassword("TestPass");
        user.setRole(1);
        user.setProjects(new ArrayList<>());
        entityManager.persist(user);
        entityManager.flush();

        Project project = new Project();
        project.setId(1);
        project.setOwner(user);
        project.setCode("777");
        project.setName("Test");
        entityManager.persistAndFlush(project);

        //When

        Set<Project> projects = projectRepository.findAllByOwner(user);

        //Then

        assertThat(projects.stream().allMatch(p->p.getOwner().getUsername().equals(user.getUsername())));
    }

    @Test
    void findAllByNameContaining() {
    }

    @Test
    void findAllByCodeContaining() {
    }
}