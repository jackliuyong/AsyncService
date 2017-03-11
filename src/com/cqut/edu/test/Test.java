package com.cqut.edu.test;

import java.util.ArrayList;
import java.util.List;

import com.cqut.edu.bean.Message;
import com.cqut.edu.client.ServiceA;
import com.cqut.edu.engin.ServiceB;
/**
 * 测试类
 * 由于另外开启了一个线程，用Junit测试时出现程序执行不完的情况，因此采用main方法的形式。
 * */
public class Test
{
	public static void main(String[] args)
	{
		
		List<Message> messages = new ArrayList<Message>(); 
		ServiceB server = new ServiceB();
		ServiceA client = new ServiceA(server);
		for (int i = 0; i < 5; i++)
		{
			int prority = (int)(Math.random()*10)+1;//产生1-10的随机数
			Message msg = new Message(prority);
			messages.add(msg);
		}
		client.sendMsg(messages);		
	}
}
