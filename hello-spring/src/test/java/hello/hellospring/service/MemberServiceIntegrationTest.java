package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
//Test가 끝나면 Rollback해줌.
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService service;
    @Autowired
    MemberRepository repository;



    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = service.join(member);


        //then
        Member findMember = service.findOne(saveId).get();
        assertThat(
                member.getName()
        ).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        service.join(member1);


        //then
        assertThrows(IllegalStateException.class, () -> service.join(member2));
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}