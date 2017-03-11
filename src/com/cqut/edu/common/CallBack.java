package com.cqut.edu.common;

import com.cqut.edu.bean.Message;

/**  
 * 
 * 信息处理的回调接口
 */
public interface CallBack
{  //业务B处理的数据会传到这儿。
   void process(Message msg);
}
