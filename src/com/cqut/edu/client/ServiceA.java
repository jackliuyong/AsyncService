package com.cqut.edu.client;

import java.util.List;

import com.cqut.edu.bean.Message;
import com.cqut.edu.common.CallBack;
import com.cqut.edu.engin.ServiceB;
/**
 * 模拟业务A
 * 实现回调接口方便和业务B进行通信。
 * */
public class ServiceA  implements CallBack
{

	private ServiceB serviceb;//和业务B产生依赖关系
	
    public ServiceA(ServiceB serviceb)
	{
		this.serviceb = serviceb;
	}
    /**业务A异步给业务B发送信息*/
    public void sendMsg(final List<Message> msgs){
        System.out.println("ServiceA：异步发送消息队列中。" );
        new Thread(new Runnable() {
            @Override
            public void run() {
            	serviceb.getClientMsg(ServiceA.this,msgs);
            }
        }).start();
        System.out.println("ServiceA：异步发送消息队列成功。");
    }

	/**接收来自业务B的处理信息*/
	@Override
	public void process(Message msg)
	{  
		if("100".equals(msg.getStatus())){
			System.out.println("ServiceA：接收到业务B正在处理优先级为"+msg.getPriority()+"的信息。");
		}else if("200".equals(msg.getStatus())){
			System.out.println("ServiceA：接收到业务B处理优先级为"+msg.getPriority()+"完成!");
		}
	    
	}

}
