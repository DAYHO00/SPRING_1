package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.apache.catalina.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");
        repository.save(member);
    }

    @Test
    public void findByName(){

        //given
        Member member1 = new Member();
        member1.setName("Spring1");

        repository.save(member1);
        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("Spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){

        //given
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}