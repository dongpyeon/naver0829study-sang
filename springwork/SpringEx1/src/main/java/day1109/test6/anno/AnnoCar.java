package day1109.test6.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mycar") // id �� mycar �� �ȴ�  //id:annoCar�� �ڵ� ���
public class AnnoCar {
	
	//@Autowired  //�ڵ� ���� - ���� �߻�: ��Ī ������ Ŭ������ 2���̹Ƿ� ������ �߻�
	//AnnoTire annotire;
	
	//�������̽��� ������ Ŭ������ �������ΰ�� ��Ȯ�ϰ� Ŭ���������� �����ϸ� �ȴ�.
	//�����ϱ� ������ �˾Ƽ� �ڵ� ���Եȴ�. (auto wire��)
	@Autowired
	//AnnoCanadaTire annoTire;
	//AnnoKoreaTire annoTire;
	
	//@Resource�� �������̽��� ������ Ŭ������ �������� ��� �� ��� �����ش�.(������ ��������)
	//@Resource(name="annoCanadaTire")
	@Resource(name="annoKoreaTire")
	AnnoTire annoTire;
	
	
	public void myCarInfo()
	{
		System.out.println("�� ���� Ÿ�̾�� "+annoTire.getTireName()+" �Դϴ�.");
	}

}
