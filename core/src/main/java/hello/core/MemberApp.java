package hello.core;

import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args){

        //스프링 컨테이너에 Bean 어노테이션으로 설정된 것들을 넣어줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //보통 메서드 이름이 name
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


    }
}
