# AsyncService
模拟有两个业务，一个为：数据的输入，记为A；另一个为：数据的计算记为B(不需要实现，模拟即可)，计算需要一定时间。现有需求就是业务A会调用业务B来计算，而且业务B是有计算队列的，B会根据业务A优先等级做一些排队等等，但是B会一直（阶段性）返回相应的操作信息到业务A，直至B计算完成。
