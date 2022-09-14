package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void order_BASIC() { // VIP 1000 discount
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(1L, "itemA", 10000);
    Assertions.assertThat(order.calculatePrice()).isEqualTo(9000); // 할인된 가격이 9000원이 맞는지
  }

  @Test
  void order_VIP() { // Basic 1000 not Discount
    Member member = new Member(1L, "memberA", Grade.BASIC);
    memberService.join(member);

    Order order = orderService.createOrder(1L, "itemA", 10000);
    Assertions.assertThat(order.calculatePrice()).isEqualTo(10000);
  }

}
