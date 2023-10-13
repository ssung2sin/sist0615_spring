package spring.di.ex1;

public class Message1 implements MessageInter {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요!!"+name+"님~~");
		
		//Spring은 xml을 등록해주지 않으면 안된다!
	}

}
