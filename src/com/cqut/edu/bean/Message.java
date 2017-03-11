package com.cqut.edu.bean;
/**
 * 封装信息的实体Bean并且让Message可以根据优先级进行比较。
 *   
 * */
public class Message implements Comparable<Message>
{
    private int priority;//消息的优先级别
    private String status;//消息的状态
    public Message()
	{
	   
	}	
    public Message(int priority)
	{
	    this.priority = priority;
		
	}    
    public int getPriority()
	{
		return priority;
	}
	public void setPriority(int priority)
	{
		this.priority = priority;
	} 
    
    public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	@Override
	public int compareTo(Message m)
	{
		return  m.getPriority()-this.getPriority();
	}	
    
}
