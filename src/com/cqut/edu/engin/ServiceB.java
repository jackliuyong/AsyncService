package com.cqut.edu.engin;

import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.cqut.edu.bean.Message;
import com.cqut.edu.common.CallBack;
/**
 * 模拟业务B处理来自业务A的消息。
 * */
public class ServiceB
{
	private Timer mTimer;
	/**得到业务A带过来的数据*/
	public void getClientMsg(CallBack csCallBack,  List<Message> messages)
	{	
		 System.out.println("ServiceB:接收到来自业务A的消息队列。");
		 Collections.sort(messages);//对来自业务A的消息队列根据优先级进行排序。		 
		 while(messages.size()!=0){ //首先处理优先级最高的消息。
			 
			 Message currentMsg = messages.remove(0);
			 System.out.println("ServiceB:正在处理优先级为"+currentMsg.getPriority()+"的信息。");		 
		     startCompute(csCallBack, currentMsg);	     
		     try //模拟计算5秒
			 {
				Thread.sleep(5000);
			 } catch (InterruptedException e)
			 {
			 	e.printStackTrace();
			 }
		     stopCompute();
			 onAccomplished(csCallBack, currentMsg);
		 }
		 System.out.println("ServiceB:所有来自业务A的消息处理完成!");
	}
	
	/**计算完成*/
	private void onAccomplished(CallBack csCallBack, Message currentMsg)
	{
		System.out.println("ServiceB:优先级为"+currentMsg.getPriority()+"的数据处理成功。");
		currentMsg.setStatus("200");
		csCallBack.process(currentMsg);
	}
	/**开始计算*/
	private void startCompute(final CallBack csCallBack, final Message currentMsg)
	{
		mTimer = new Timer();		
		mTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				currentMsg.setStatus("100");			 
				csCallBack.process(currentMsg);
			}
		}, 0, 1000);//每隔一秒执行一次	
		
	}
	/**停止计算*/
	private void stopCompute() {
		if (mTimer != null) {
			mTimer.cancel();
			mTimer = null;			
		}
	}

}
