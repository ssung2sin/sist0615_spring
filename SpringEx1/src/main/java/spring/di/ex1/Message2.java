package spring.di.ex1;

public class Message2 implements MessageInter {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("오랜만이네요~~"+name+"씨!!!");
		
		//Spring은 xml을 등록해주지 않으면 안된다!
	}

}
